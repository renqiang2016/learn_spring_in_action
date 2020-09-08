package com.ren.learn_spring_in_action.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 9:47
 */
public interface UserDetailService {

    UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;
}
