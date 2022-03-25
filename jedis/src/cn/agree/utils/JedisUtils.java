package cn.agree.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    private static JedisPoolConfig poolConfig = null;
    private static JedisPool jedisPool = null;

    private static Integer maxTotal = null;
    private static Integer maxIdle = null;
    private static String host = null;
    private static Integer port = null;

    static {
        // 读取配置文件 获得参数
        ResourceBundle rb = ResourceBundle.getBundle("jedis");
        maxTotal = Integer.parseInt(rb.getString("jedis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("jedis.maxIdle"));
        port = Integer.parseInt(rb.getString("jedis.port"));
        host = rb.getString("jedis.host");

        System.out.println(maxTotal+"---"+maxIdle+"---"+port+"---"+host);

        poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(poolConfig,host,port);
    }

    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

}
