package com.test.redis;/**
 * Created by sunxueyan on 2020/7/20.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @ClassName Redislock
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/7/20
 * @Version V1.0
 **/
@Service
public class Redislock {


    @Autowired
    private RedisTemplate redisTemplate;

    public String select(int id){
        String key = "order_" + id;
        ValueOperations valueOperations = redisTemplate.opsForValue();

        Boolean exist = redisTemplate.hasKey(key);
        if(exist){
            Object o = valueOperations.get(key);
            System.out.println(o);
            return o + "";
        }
        return "";
    }
}
