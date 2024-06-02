package com.gilfoyle.BreastCancer.Security;


import com.gilfoyle.BreastCancer.entity.User;
import com.gilfoyle.BreastCancer.model.UserContext;
import com.gilfoyle.BreastCancer.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.StringUtils.isEmpty;

@Component
//@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";
    private final JwtTokenUtil jwtTokenUtil;
    private final BreastCancerUserDetailsService eddUserDetailsService;
    private final UserRepository userRepository;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, BreastCancerUserDetailsService eddUserDetailsService, UserRepository userRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.eddUserDetailsService = eddUserDetailsService;
        this.userRepository = userRepository;
    }

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (isEmpty(request.getHeader(AUTHORIZATION))) {
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = parseJwt(request);

        if (Objects.nonNull(jwtToken)) {
            UserDetails userDetails = eddUserDetailsService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
            setAuthentication(request, userDetails);
            chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }


    private void setAuthentication(HttpServletRequest request, UserDetails userDetails) {
        User user = userRepository.findBySecurityUser_Username(userDetails.getUsername()).get();
        try {
            UserContext userContext = new UserContext(user);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userContext, userDetails, userDetails.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(request);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } catch (Exception e) {
            System.out.println("Kimlik doğrulanırken hata meydana geldi.");
        }
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader(AUTHORIZATION);

        if (hasText(headerAuth) && headerAuth.startsWith(BEARER)) {
            return headerAuth.substring(7);
        }
        return null;
    }
}
