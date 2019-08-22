package com.miyu.springboot.controller.user;

import java.util.ArrayList;
import java.util.List;

public class test {

/*        public static void main(String[] args){
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

    }*/

/*    public static void main(String[] args) {
        String json3="{'1':{'name':'zhangsan'},'3':{'name':'lisi'},'4':{'name':'wangwu'}}";
        JSONObject jsonObj = JSONObject.fromObject(json3);
        Gson gson  = new Gson();
        gson.toJson(jsonObj);
        System.out.println( gson.toJson(jsonObj));
    }*/

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        List<String> c = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");

        b.add("1");
        b.add("2");
        b.add("3");
        b.add("4");

        c.add("x");
        c.add("y");
        c.add("z");
        c.add("w");


        List<List<String>> list = new ArrayList<List<String>>();
        list.add(a);
        list.add(b);
        list.add(c);

        //笛卡尔积生成
        List<String> li = createdikaerji(list);
        System.out.println(li);

    }

    private static List<String> createdikaerji(List<List<String>> list) {
        List<String> li = new ArrayList<>();

        if (list.size() > 0) {
            List<String> a = list.get(0);
            List<String> b = list.get(1);

            for (int i = 0; i < a.size(); i++) {
                for (int y = 0; y < b.size(); y++) {

                    li.add(a.get(i));
                    li.add(b.get(y));
                }
            }
            list.remove(0);
            System.out.println(list);
            System.out.println("aaaaaaaaaaa" + list.size());
/*            if (list.size()>0){
                list.add(0,li);
                System.out.println(list);
                createdikaerji(list);
            }*/
        } else {
            return li;
        }

        return li;
    }


}
