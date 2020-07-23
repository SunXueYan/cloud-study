package com.test.controller;/**
 * Created by sunxueyan on 2020/7/20.
 */

import com.test.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.redis.Redislock;

/**
 * @ClassName OrderTestController
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/7/20
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class OrderTestController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Redislock redislock;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("/select")
    public String select(int id){
        return redislock.select(id);
    }

    @GetMapping("/setnx/{key}/{val}")
    public boolean setnx(@PathVariable String key, @PathVariable String val) {
        return redisUtil.setnx(key, val); }


    @GetMapping("/delnx/{key}/{val}")
    public int delnx(@PathVariable String key, @PathVariable String val) {
        return redisUtil.delnx(key, val); }
}
