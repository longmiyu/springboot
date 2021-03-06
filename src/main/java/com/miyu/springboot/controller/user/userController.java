package com.miyu.springboot.controller.user;


import com.miyu.springboot.common.commonData.RedisUtils;
import com.miyu.springboot.entity.UserTableEntity;
import com.miyu.springboot.service.user.userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService us;
    private RedisUtils reu;

    @RequestMapping("/index")
    public String userIndex(Model model) {

        System.out.println("aaaaa3vvddcc");
        System.out.println("aaaaaaaaaaaaaa");

        ModelAndView mav = new ModelAndView();
        List<UserTableEntity> s = us.query();
        List<Map<String, Object>> str = us.userService();
        model.addAttribute("users", str);
        System.out.println(3);

        return "user/userList";
    }

    @RequestMapping("/insert")
    public String userInsert() {
        us.userInsert();

        return "保存成功";
    }

    @RequestMapping("/save")
    public String saveUser() {
        us.saveUser();

        return "保存成功";
    }


    @RequestMapping("/query")
    public String queryList() {

        //查询返回实体对象
        List<UserTableEntity> use = us.query();

        return null;

    }

/*    @RequestMapping("/test")
    @ResponseBody
    public JSONObject test(@RequestBody String str) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + str);
        JSONObject jo = JSONObject.fromObject(str);
        JSONObject test = new JSONObject();
        System.out.println(str + "aaaaaaaaaaaaaaaaaabbb");
        test.put("name", "张三");
        return test;
    }*/

    @RequestMapping("/url")
    public ModelAndView urlContion() throws Exception {
        JSONObject jo = us.urlContion();
        ModelAndView mav = new ModelAndView();
        JSONObject s = JSONObject.fromObject(jo);
        JSONObject test = new JSONObject();
        test.put("name", "张三");
        test.put("sex", "男");
        mav.addObject("cs", test);
        mav.setViewName("user/weather");
        return mav;
    }

    @RequestMapping("/openDialog")
    public String openDialog(String url) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + url);
/*       JSONObject jo = JSONObject.fromObject(data);
       String url = jo.getString("url");
        jo.remove("url");
        System.out.println(">>>>>>>>>>>>"+url);
        ModelAndView mav = new ModelAndView();
        mav.addObject(jo);
        mav.setViewName(url);*/
        return url;
    }
    @RequestMapping("/test")
    public  ModelAndView test(){
        JSONObject jo = new JSONObject();

        List<Map<String, Object>> str = us.userService();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/test");
       mav.addObject("data",str);
        return mav;
    }
}
