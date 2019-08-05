package com.miyu.springboot.service.user;

import com.miyu.springboot.entity.UserTableEntity;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface userService {
    public List<Map<String,Object>> userService();
    void userInsert();

    void saveUser();

    List<UserTableEntity> query();

    JSONObject urlContion() throws Exception;
}
