package com.test.util;/**
 * Created by sunxueyan on 2020/7/20.
 */

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @ClassName RedisUtile
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/7/20
 * @Version V1.0
 **/
@Component
public class RedisUtil {
    private static final Logger LOGGER    = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 设置缓存
     * @param key    缓存key
     * @param value  缓存value
     */
    public void set(String key, String value) {
        jedisCluster.set(key, value);
        LOGGER.debug("RedisUtil:set cache key={},value={}", key, value);
    }

    /**
     * 设置缓存对象
     * @param key    缓存key
     * @param obj  缓存value
     */
    public <T> void setObject(String key, T obj , int expireTime) {
        jedisCluster.setex(key, expireTime, JSON.toJSONString(obj));
    }

    /**
     * 获取指定key的缓存
     * @param key---JSON.parseObject(value, User.class);
     */
    public String getObject(String key) {
        return jedisCluster.get(key);
    }

    /**
     * 判断当前key值 是否存在
     *
     * @param key
     */
    public boolean hasKey(String key) {
        return jedisCluster.exists(key);
    }


    /**
     * 设置缓存，并且自己指定过期时间
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime( String key, String value, int expireTime) {
        jedisCluster.setex(key, expireTime, value);
        LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", key, value, expireTime);
    }


    /**
     * 获取指定key的缓存
     * @param key
     */
    public String get(String key) {
        String value = jedisCluster.get(key);
        LOGGER.debug("RedisUtil:get cache key={},value={}",key, value);
        return value;
    }

    /**
     * 删除指定key的缓存
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
        LOGGER.debug("RedisUtil:delete cache key={}", key);
    }

    /**
     * @MethodName: setnx
     * @Description: 设置分布式锁
     * @Param: [key, val]
     * @Return: boolean
     * @Author: sunxueyan
     * @Date: 2020/7/20
    **/
    public boolean setnx(String key, String val){
        try {
            return jedisCluster.set(key, val, "NX", "PX", 1000*60).equalsIgnoreCase("ok");
        }catch (Exception e){
//            throw new RuntimeException();
        }
        return false;
    }

    /**
     * @MethodName: delnx
     * @Description: 删除分布式锁
     * @Param: [key, val]
     * @Return: boolean
     * @Author: sunxueyan
     * @Date: 2020/7/20
    **/
    public int delnx(String key, String val){
        try {
        //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").append(" then")
                .append(" return redis.call('del','").append(key).append("')").append(" else return 0 end");
            String s = get(key);
            List<String> keys = new ArrayList<>();
            keys.add(key);
            List<String> argv = new ArrayList<>();
            argv.add(val);
            Object eval = jedisCluster.eval(sb.toString(), keys, argv);
            return Integer.valueOf(eval + "");
        }catch (Exception e){

        }
        String s = get(key);
        return 0;
    }

}