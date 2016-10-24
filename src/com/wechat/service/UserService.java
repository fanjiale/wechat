package com.wechat.service;

import com.wechat.pojo.User;

/**
 * Created by fanjl on 2016/9/30.
 */
public interface UserService {
    boolean validateUserInfo(String username, String password);

    User findUserByName(String username);
}
