package com.miyu.springboot.common.commonData.filter;


import org.springframework.core.env.Environment;


/**
 *读取配置内容
 */
public class PropertiesUtil {


    private static Environment env = null;

    public static void setEnvironment(Environment env) {
        PropertiesUtil.env = env;
    }

    public static String getProperty(String key) {
        return PropertiesUtil.env.getProperty(key);
    }


}
