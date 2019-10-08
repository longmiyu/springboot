package com.miyu.springboot.controller.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t {
    public static void main(String[] args) {
        List<String> nums = new ArrayList<String>();
        nums.add("1001");
        nums.add("100101");
        nums.add("1002");
        nums.add("1000");
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }

}
