package com.breach.huajinbao.util.quest;

public class test {
    public static void main(String[] args){
        test1();
    }
    public static String  test1(){
        String a="";
        int one = (int) (Math.random() * 5);
        if (one == 0) {
            a = "稳重型";
            System.out.println(a);

        }
        if (one == 1) {
            a = "保守型";
            System.out.println(a);

        }
        if (one == 2) {
            a = "平衡性";
            System.out.println(a);
        }
        if (one == 3) {
            a = "成长性";
            System.out.println(a);
        }
        if (one == 4) {
            a = "进取型";
            System.out.println(a);
        }
        return a;
    }
}