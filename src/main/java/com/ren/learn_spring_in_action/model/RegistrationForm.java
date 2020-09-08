package com.ren.learn_spring_in_action.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 10:19
 */
@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname,
                street, city, state, zip, phone);
    }
}
