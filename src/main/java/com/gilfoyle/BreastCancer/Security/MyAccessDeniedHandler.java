package com.gilfoyle.BreastCancer.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import java.io.IOException;

public  class MyAccessDeniedHandler extends AccessDeniedHandlerImpl {
    private HttpRequestEndpointChecker endpointChecker;

    public MyAccessDeniedHandler(HttpRequestEndpointChecker endpointChecker) {
        this.endpointChecker = endpointChecker;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        if (!endpointChecker.isEndpointExist(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        } else {
            super.handle(request, response, accessDeniedException);
        }
    }
}