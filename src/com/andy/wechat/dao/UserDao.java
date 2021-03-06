package com.andy.wechat.dao;

import com.alibaba.fastjson.JSONObject;
import com.skytech.ark.jdbc.IGenericDAO;

import java.util.List;

/**
 * Created by fanjl on 2016/9/30.
 */
public interface UserDao extends IGenericDAO<JSONObject>{

    List<JSONObject> listUserByUserName(String username);
}
