package com.miyu.springboot.controller.user;

import com.miyu.springboot.entity.UserTableEntity;
import com.miyu.springboot.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private  userService us;

    @RequestMapping("/index")
    public String userIndex(Model model){
        System.out.println("aaaaaaaaaaaaaa");
        ModelAndView mav = new ModelAndView();
        List<Map<String,Object>> str = us.userService();
        model.addAttribute("users",str);
        return "user/userList";
    }

    @RequestMapping("/insert")
    public String userInsert(){
        us.userInsert();

        return "保存成功";
    }

    @RequestMapping("/save")
    public String saveUser(){
        us.saveUser();

        return "保存成功";
    }


    @RequestMapping("/query")
    public String queryList(){

        //查询返回实体对象
        List<UserTableEntity> use = us.query() ;

        return null;

    }
}
