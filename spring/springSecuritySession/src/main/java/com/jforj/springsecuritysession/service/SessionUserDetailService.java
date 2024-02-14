package com.jforj.springsecuritysession.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SessionUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // *** DB or 외부 API로부터 사용자 정보 및 권한 정보를 조회하는 구간 ***
        // *** 해당 코드에서는 구현하지 않기 때문에 정보를 조회하지 않고 더미 데이터를 활용 ***

        String userId = username;
        String userPassword = "password";
        String[] userRoles = new String[]{};
        switch (username) {
            // 로그인한 사용자가 admin인 경우 ROLE_ADMIN, ROLE_USER 권한 부여
            case "admin": {
                userRoles = new String[]{"ADMIN", "USER"};
                break;
            }

            // 로그인한 사용자가 user인 경우 ROLE_USER 권한 부여
            case "user": {
                userRoles = new String[]{"USER"};
                break;
            }
        }

        // userDetails는 필요한 경우 커스텀하여 사용할 수 있음
        UserDetails userDetails =
                User
                        .withUsername(userId)
                        .password(passwordEncoder.encode(userPassword))
                        .roles(userRoles)
                        .build();

        return userDetails;
    }
}
