package com.welisit.test;

import org.junit.Test;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-20 22:16
 */
public class ParseIntTest {
    @Test
    public void test(){
        String str = "ads";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }
}
