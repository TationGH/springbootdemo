package com.example.springbootdemo;

import com.example.springbootdemo.config.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
public class RedisTest {
    @Autowired
    RedisUtils redisUtils;

    @Test
    public void testKey() {
        redisUtils.set("javaKey", "TEST");
    }

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

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testRedis() throws Exception {
        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://192.168.1.1:8001")
                .setPassword("redis-pw").setDatabase(0);
        RedissonClient redissonClient1 = Redisson.create(config1);

        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://192.168.1.2:8001")
                .setPassword("redis-pw").setDatabase(0);
        RedissonClient redissonClient2 = Redisson.create(config2);

        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://192.168.1.3:8001")
                .setPassword("redis-pw").setDatabase(0);
        RedissonClient redissonClient3 = Redisson.create(config3);

        String resourceName = "REDLOCK_KEY";
        RLock lock1 = redissonClient1.getLock(resourceName);
        RLock lock2 = redissonClient2.getLock(resourceName);
        RLock lock3 = redissonClient3.getLock(resourceName);

        RedissonRedLock rLock = new RedissonRedLock();
        try {
            boolean isLock = rLock.tryLock(50, 1000, TimeUnit.MILLISECONDS);
            if (isLock) {
                //TODO if get lock success, do something;
            }
        } finally {
            rLock.unlock();
        }
    }
}