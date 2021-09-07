package com.example.springbootdemo;

import com.example.springbootdemo.service.RedisUtils;
import sun.awt.Mutex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zts
 * @Date 2021/8/31 17:34
 * @Classname TEST
 * @Description
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        int N = 2;
        final CountDownLatch latch = new CountDownLatch(N);//初始化计数器值2
        for (int i = 0; i < N; i++) {
            new Thread() {
                public void run() {
                    System.out.println("子线程" + Thread.currentThread().getName() + "计数器值:" + latch.getCount());
                    latch.countDown();//计数器值减1
                }
            }.start();
        }

        latch.await();//阻塞到计数器值=0才继续往下执行
        System.out.println("主线程" + Thread.currentThread().getName() + "计数器值:" + latch.getCount());
    }
}
