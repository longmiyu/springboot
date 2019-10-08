package com.miyu.springboot.dao.daoImpl.user;

import com.miyu.springboot.common.commonData.commonDAO;
import com.miyu.springboot.dao.user.userDao;
import com.miyu.springboot.entity.UserTableEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class userDaoImpl extends commonDAO implements userDao  {
    @Override
    public List<Map<String,Object>> userDao() {
        UserTableEntity user= new UserTableEntity();
        user.setUserCode("01");
        user.setUserName("张三");
        user.setUserPassword("123456");
        user.setUserEmail("");
        user.setUserPhone("12345678940");
        String strs = "select * from user_table ";
        List<Map<String,Object>> userTable =  this.querySqlByList(strs);
        System.out.println(userTable);
        return userTable;
    }

    /**
     * 数据保存
     */
    @Override
    public void userInsert() {
        String user_code = "10002";
        String user_name = "李四";
        String user_password ="123456";
        String user_email = "123456+789@qq.com";
        String user_phone="12356478";
        StringBuffer inserSql = new StringBuffer();
        inserSql.append("insert into user_table (user_code, user_name, user_password, user_email,  user_phone )");
        inserSql.append(" values (  ");
        inserSql.append("'").append(user_code).append("',");
        inserSql.append("'").append(user_name).append("',");
        inserSql.append("'").append(user_password).append("',");
        inserSql.append("'").append(user_email).append("',");
        inserSql.append("'").append(user_phone).append("')");
        this.updateSql(inserSql.toString());

    }

    @Override
    public void saveUser() {
        UserTableEntity user= new UserTableEntity();
        user.setUserCode("0012");
        user.setUserName("李四2");
        user.setUserPassword("123456");
        user.setUserEmail("2221");
        user.setUserPhone("12345678940");
        this.insert(user);
    }

    @Override
    public  List<UserTableEntity> query() {

        List<UserTableEntity> use  = new ArrayList<UserTableEntity>() ;

        try {
            use = this.executeHqlQuery("from UserTableEntity",UserTableEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return use;
    }
}
