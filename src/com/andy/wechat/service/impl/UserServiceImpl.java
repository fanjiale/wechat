package com.andy.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.andy.wechat.dao.UserDao;
import com.andy.wechat.service.UserService;
import com.andy.wechat.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanjl on 2016/9/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean validateUserInfo(String username, String password) {
        List<JSONObject> users = userDao.listUserByUserName(username);

        if (!users.isEmpty()) {
            JSONObject user = users.get(0);

            String ps = user.getString("password");

            if (DigestUtils.md5Hex(password).endsWith(ps)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserByName(String username) {
        User user = new User();
        List<JSONObject> users = userDao.listUserByUserName(username);

        if(!users.isEmpty()){
            JSONObject item = users.get(0);

            user.setUsername(username);
        }

        return user;
    }


}
