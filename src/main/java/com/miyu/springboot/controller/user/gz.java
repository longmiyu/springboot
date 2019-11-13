package com.miyu.springboot.controller.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gz {
    public static void main(String[] args) {
        String gz = "4-2-2-2-2";
        String code ="100102030405";

        List<String>  ss =getSt( gz,  code);
        System.out.println(ss);
    }

    private static List<String> getSt(String gz, String code) {
        List<String> s = new ArrayList<>();
        String [] ar =  gz.split("-") ;
        List<Integer> ww = new ArrayList<>() ;


        int qq=0;
        for (int y=0;y<ar.length;y++){
            qq+=Integer.valueOf(ar[y]);
            ww.add(0,Integer.valueOf(ar[y]));
            if (qq==code.length()){
            System.out.println(ww);
            break;}
        }

    int dd=0;
        for (int i=0;i<ww.size();i++){
            //System.out.println("code1"+code);
            dd+=ww.get(i);

            String c = code.substring(0,code.length()-dd);
            if (c.length()==0)
                break;
            else
                s.add(c);
            System.out.println("code>>>>>>>"+c);

            }
        Collections.sort(s);


        return s ;

    }
}
