package com.jforj.threadlocal.threadlocal;

import com.jforj.threadlocal.dto.User;

public class UserThreadLocal {
    // singleton pattern을 활용한 instance 구성
    private static class UserThreadLocalHolder {
        private static final ThreadLocal<User> Instance = new ThreadLocal<>();
    }

    public static ThreadLocal<User> getInstance() {
        return UserThreadLocalHolder.Instance;
    }
}
