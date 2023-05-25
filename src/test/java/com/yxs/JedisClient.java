package com.yxs;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;


public class JedisClient {
//    单实例连接Redis
    @Test
    public void JedisClient(){
//        String
        Jedis jedis = new Jedis("192.168.40.129", 6379);
        jedis.set("s8", "uzi");
        String result = jedis.get("s8");
        System.out.println(result);
        jedis.close();

    }

    //使用jedis连接池连接Redis服务器
    @Test
    public void jedisPool(){
        JedisPool jedisPool = new JedisPool("192.168.40.129", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("s9", "ig");
        String s8 = jedis.get("s9");
        System.out.println(s8);
        jedis.close();
        jedisPool.close();

    }
}
