package com.ren.learn_spring_in_action.service.impl;

import com.ren.learn_spring_in_action.dao.repository.UserRepository;
import com.ren.learn_spring_in_action.model.User;
import com.ren.learn_spring_in_action.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 9:51
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "'not found");
    }
}
