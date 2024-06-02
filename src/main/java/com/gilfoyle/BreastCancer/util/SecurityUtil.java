package com.gilfoyle.BreastCancer.util;

import com.gilfoyle.BreastCancer.model.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.CustomLog;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtil {
    private static Optional<Authentication> getAuthentication() {
        return ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication);
    }

    public static Optional<UserContext> getUserContext() {
        return getAuthentication()
                .map(Authentication::getPrincipal)
                .map(UserContext.class::cast);
    }

    public static String getAuthenticationToken() {
        return getAuthentication()
                .map(Authentication::getDetails)
                .map(HttpServletRequest.class::cast)
                .map(request -> request.getHeader("Authorization").substring(7))
                .orElse(null);
    }

    public static Long getUserId() {
        return getUserContext()
                .map(UserContext::getId)
                .orElse(null);
    }

    public static String getUsername() {
        return getUserContext()
                .map(userContext -> userContext.getSecurityUser().getUsername())
                .orElse(null);
    }

}
