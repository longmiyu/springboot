package com.miyu.springboot.common.commonData.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private List<String> url = new ArrayList();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("addmin")!=null)
            return true;
        else
            response.sendRedirect("admin/login");	//未登录，跳转到登录页
        return false;
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }
    /**
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
    /**
     * 定义排除拦截URL
     * @return
     */
    public List<String> getUrl(){
        url.add("/admin/login");      //登录页
        url.add("/admin/login/in");   //登录action URL

        //网站静态资源
        url.add("/css/**");
        url.add("/js/**");
        url.add("/lib/**");
        url.add("/fonts/**");
        url.add("/images/**");
        return url;
    }


}
