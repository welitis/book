package com.welisit.test;

import com.welisit.service.OrderService;
import org.junit.Test;

import java.util.Random;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 23:29
 */
public class ThreadTest {
    @Test
    public void test() {
        System.out.println(Thread.currentThread().getName());
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread1开始运行");
                System.out.println("thread1的线程名：" + this.getName());
            }
        };
        thread1.start();
    }

    @Test
    public void test2() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束运行");
            }
        };
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            thread = new Thread(runnable);
            thread.start();
//            thread.join();
        }
        Thread.sleep(5000);
        System.out.println(thread.isAlive());
    }


    @Test
    public void test3() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new ThreadLocalTest.Task()).start();
        }
        Thread.sleep(5000);
    }
}

class OrderService1 {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程[" + name + "]中保存的数据是：" +
                ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }
}
class OrderDao {
    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao 当前线程[" + name + "]中保存的数据是：" +
                ThreadLocalTest.threadLocal.get());
    }
}


class ThreadLocalTest {
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    private static Random random = new Random();

    public static class Task implements Runnable {
        @Override
        public void run() {
// 在Run 方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key 保存到map 中
            Integer i = random.nextInt(1000);
// 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]生成的随机数是：" + i);
// data.put(name,i);
            threadLocal.set(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService1().createOrder();
// 在Run 方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
// Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程[" + name + "]快结束时取出关联的数据是：" + o);
        }
    }




}
