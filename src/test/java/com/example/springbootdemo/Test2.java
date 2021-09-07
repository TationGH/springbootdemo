package com.example.springbootdemo;

import java.util.concurrent.Semaphore;

/**
 * @Author Zts
 * @Date 2021/9/7 17:16
 * @Classname Test2
 * @Description
 **/
public class Test2 {
    public static void main(String[] args) {
        int N = 2;
        Semaphore semaphore = new Semaphore(N); //
        for (int i = 0; i < 4; i++) {
            new Thread() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "占用");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "释放");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
