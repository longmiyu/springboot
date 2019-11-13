package com.miyu.springboot.common.commonData;


import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Component

public class RedisUtils {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    private  final static  String host = resourceBundle.getString("spring.redis.host");
    private  final static  int port = Integer.valueOf(resourceBundle.getString("spring.redis.port"));
    private  final static  String password = resourceBundle.getString("spring.redis.password");
    private static String ADDR =host;
    private static int PORT = port;
    private static String AUTH = password;
    // 最大连接实例数，默认为8，-1表示无限制，如果pool已经分配了超过max_active个jedis实例，则此时pool为耗尽
    private static int MAX_ACTIVE = 1024;
    // 最大空闲实例，默认为8
    private static int MAX_IDLE = 200;
    // 最大等待连接时间，单位毫秒默认为-1，表示永不超时，超时会抛出JedisConnectionException
    private static int MAX_WAIT = 10 * 1000;
    private static int TIMEOUT = 10 * 1000;
    // 在borrow一个jedis实例时，是否提前进行validate操作，如果为true，则得到的jedis实例均是可用的
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;
    /**
     * 初始化连接池
     */
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        jedisPool = new JedisPool(config, ADDR, PORT);
    }

    /**
     * 获取jedis实例
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool != null) {

            Jedis resource = jedisPool.getResource();
            return resource;
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @param jedis
     */
    public static void close(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
/*


    /**
     * 缓存List<T>
     * @param key
     * @param list
     */
    public void SetList(String key , List<?> list){
        Jedis jedis = getJedis();
        try {
                if (list.size() > 0) {
                    jedis.set(key.getBytes(), SerializeUtil.serializeList(list));

                }
        }
            catch (Exception e) {
            }

        finally {
            jedis.close();
        }

    }

    /**
     * 获取List集合
     * @param key
     * @return
     */
    public static List<?> getList(String key){
        Jedis jedis = getJedis();
        if(jedis == null || !jedis.exists(key)){
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        return SerializeUtil.unserializeList(data);
    }

/*

   	/**
	 * 设置 map
	 * @param <T>
	 * @param key
	 * @param value
	 */
public <T> void SetMap(String key , Map<String,T> map){
    Jedis jedis = getJedis();
    try {
        if (map.isEmpty())
        {
            getJedis().set(key.getBytes(),SerializeUtil.serialize(map));
        }

    } catch (Exception e) {

    }finally {
        jedis.close();
    }
}
    /**
     * 获取Map
     * @param <T>
     * @param key
     * @return list
     */
    public <T> Map<String,T> getMap(String key){
        Jedis jedis = getJedis();
        if(getJedis() == null || !getJedis().exists(key.getBytes())){
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        Map<String,T> map = (Map<String, T>) SerializeUtil.unserialize(data);
        return map;
    }


    /**
     * 删除key
     */
    public static Long deleteObject(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.del(key.getBytes());
        } catch (Exception e) {
            return null;
        } finally {
            close(jedis);
        }
    }

    /**
     * 检查存在
     *
     * @param key
     * @return
     */
    public static Boolean existsObject(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.exists(key.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

         }
