package com.miyu.springboot.controller.user;

public class test  {

        public static void main(String[] args){
            int n;
            n = fun(0);
            System.out.println("原来有"+n+"个桃子");
        }
        private static int fun(int i){
            System.out.println(">>>>>"+i);
            if(i==5)
                return 1;
            else

                return fun(i+1)*5+1;

    }
}
