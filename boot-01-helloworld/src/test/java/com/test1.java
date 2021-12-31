package com;


import org.junit.jupiter.api.Test;

public class test1 {

    @Test
    public void test(){
        //一共52周，已过17周，还剩35周
        //4个月，一个月4周，一共16周
        //
        int i = 0;
        int sum = 0;
        for (int x = 1;x <= 52 ;x ++){
            i += 10;
            sum += i;
            System.out.println(i);
        }
        System.out.println("总和：sum = " + sum);
    }
}
