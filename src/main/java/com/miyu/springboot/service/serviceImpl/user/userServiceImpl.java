package com.miyu.springboot.service.serviceImpl.user;

import com.miyu.springboot.dao.user.userDao;
import com.miyu.springboot.entity.UserTableEntity;
import com.miyu.springboot.service.user.userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class userServiceImpl  implements userService {
    @Autowired
    private userDao ud;
    @Override
    public List<Map<String,Object>> userService() {
        List<Map<String,Object>> str = ud.userDao();
        return str;
    }

    @Override
    public void userInsert() {
        ud.userInsert();
    }

    @Override
    public void saveUser() {
        UserTableEntity user= new UserTableEntity();
        user.setUserCode("001");
        user.setUserName("李四");
        user.setUserPassword("123456");
        user.setUserEmail("222");
        user.setUserPhone("12345678940");

      //  baseDao.add(user);

        ud.saveUser();
    }

    @Override
    public  List<UserTableEntity> query() {

        List<UserTableEntity> use= ud.query();

        return use;
    }

    @Override
    public JSONObject urlContion() throws Exception {
        JSONObject json = new JSONObject();
        URL urlObject = new URL("https://www.tianqiapi.com/api/");
        URLConnection uc = urlObject.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
        String inputLine = null;
        while ( (inputLine = in.readLine()) != null) {
            json.put("returnValue",inputLine);
        }
        in.close();
       // System.out.println(json);
        return json;

    }
}
