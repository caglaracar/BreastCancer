package com.gilfoyle.BreastCancer.Security;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
@Entity
@Table(name = "securityuser")
@Data
public class SecurityUser extends SecurityProperties.User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
}
