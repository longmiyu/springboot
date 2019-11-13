package com.miyu.springboot.common.commonData.filter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice

public class MyException {


    public static final  String Error_View ="error/error";
    //@ExceptionHandler (value = Exception.class) 表示对Exception异常进行捕获
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURI());
        mav.setViewName(Error_View);
        return mav;
    }


}
