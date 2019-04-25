package com.miyu.springboot.dao.user;

import com.miyu.springboot.entity.UserTableEntity;

import java.util.List;
import java.util.Map;

public interface userDao {
    List<Map<String,Object>> userDao();

    void userInsert();

    void saveUser();

    List<UserTableEntity> query();
}
