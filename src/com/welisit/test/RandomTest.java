package com.welisit.test;

import org.junit.Test;

import java.util.Random;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 13:08
 */
public class RandomTest {
    @Test
    public void test(){
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {

            System.out.println(random.nextInt(9));
        }
    }
}
