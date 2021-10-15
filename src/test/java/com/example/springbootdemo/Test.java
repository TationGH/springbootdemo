package com.example.springbootdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zts
 * @Date 2021/9/12 11:31 上午
 * @Classname Test
 * @Description
 **/
public class Test {
    /**
     * @Author Zts
     * @Date 2021/9/12 21:32:00
     * @Method main
     * @Description
     * @Param [args]
     * @Return void
     **/
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\IOTest.txt");
        FileInputStream is = null;
        InputStreamReader reader = null;
        char[] buffer = new char[15];
        try {
            is = new FileInputStream(f);
            reader = new InputStreamReader(is, "UTF-8");//使用指定的字符集读取字节并将它们解码为字符
            while (reader.ready()) {//读取为空时退出循环
                System.out.println((char) reader.read());//读取一个字符
                int n = reader.read(buffer);//缓冲区一次读取多个字符
                System.out.println("读取" + n + "个字符");
                System.out.println(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) reader.close();//关闭流释放资源
        }
    }
}
