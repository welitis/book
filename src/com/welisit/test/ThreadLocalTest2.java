package com.welisit.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-28 8:17
 */
public class ThreadLocalTest2 {
    @Test
    public void test(){
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Random random = new Random();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name + "开始运行");
                int i = random.nextInt(1000);
                threadLocal.set(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "取出的值是" + threadLocal.get());
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Map map = new HashMap();
        Random random = new Random();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int i = random.nextInt(1000);
                System.out.println(name + "开始运行,放入的值是" + i);
                map.put(name, i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "取出的值是" + map.get(name));
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }
}

class Foo {
    public void doSomething(){

    }
}