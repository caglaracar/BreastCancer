package com.gilfoyle.BreastCancer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private String jwtToken;

    // Private constructor to enforce the use of builder
    private LoginResponse(Builder builder) {
        this.jwtToken = builder.jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    // Static nested builder class
    public static class Builder {
        private String jwtToken;

        public Builder() {
        }

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(this);
        }
    }

    // Static method to get a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}