package com.example.springbootdemo;

import com.example.springbootdemo.config.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
public class RedisTest {
    @Autowired
    RedisUtils redisUtils;

    @Test
    public void test() {
        SessionCallback sessionCallback1 = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 20000; i < 40000; i++) {
                    int j = i + 1;
                    redisUtils.set("key" + j, "value" + j);
                    redisUtils.get("key" + j);
                }
                return null;
            }
        };
        long start1 = System.currentTimeMillis();
        redisUtils.execute(sessionCallback1);
        long end1 = System.currentTimeMillis();
        System.out.println("未使用流水线:" + String.valueOf(end1 - start1));

        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 20000; i < 40000; i++) {
                    int j = i + 1;
                    redisUtils.set("key" + j, "value" + j);
                    redisUtils.get("key" + j);
                }
                return null;
            }
        };
        long start2 = System.currentTimeMillis();
        redisUtils.executePipelined(sessionCallback);
        long end2 = System.currentTimeMillis();
        System.out.println("使用流水线:" + String.valueOf(end2 - start2));
    }
}