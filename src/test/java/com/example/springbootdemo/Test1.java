package com.example.springbootdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author Zts
 * @Date 2021/9/7 16:13
 * @Classname Test1
 * @Description
 **/
public class Test1 {
    public static void main(String[] args) {
        int N = 2;
        CyclicBarrier barrier = new CyclicBarrier(N);//初始化栅栏：等待值0，阀值2
        for (int i = 0; i < 4; i++) {
            new Thread() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "等待值:" + barrier.getNumberWaiting());
                        barrier.await();//等待值加1 并 阻塞线程。如果等待值=阀值-1，则继续往下执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
