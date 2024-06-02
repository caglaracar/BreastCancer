package com.gilfoyle.BreastCancer.Security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

@Slf4j
public class HttpRequestEndpointChecker {

    private DispatcherServlet servlet;

    public HttpRequestEndpointChecker(DispatcherServlet servlet) {
        this.servlet = servlet;
    }

    public boolean isEndpointExist(HttpServletRequest request) {

        for (HandlerMapping handlerMapping : servlet.getHandlerMappings()) {
            try {
                HandlerExecutionChain foundHandler = handlerMapping.getHandler(request);
                if (foundHandler != null) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Error!");
                return false;
            }
        }
        return false;
    }
}   