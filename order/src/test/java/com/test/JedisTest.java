package com.test; /**
 * Created by sunxueyan on 2020/7/20.
 */

/**
 * @ClassName com.test.JedisTest
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/7/20
 * @Version V1.0
 **/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.test.util.RedisUtil;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void addtest(){
        redisTemplate.opsForValue().set("order_01", "test01");
        Object order_01 = redisTemplate.opsForValue().get("order_01");
        System.out.println((String) order_01);
    }


    @Autowired
    private JedisCluster jedisCluster;
    @Test
    public void jedisAddTest(){
        redisUtil.set("order_02", "test02");
        String order_02 = redisUtil.get("order_02");
        System.out.println(order_02);

        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call('get','").append("order_02").append("')").append("=='").append("test02").append("'").append(" then")
                .append(" return redis.call('del','").append("order_02").append("')").append(" else return 0 end");

        List<String> keys = new ArrayList<>();
        keys.add("order_02");
        List<String> argv = new ArrayList<>();
        argv.add("test02");
        System.out.println(jedisCluster.eval(sb.toString(), keys, argv) + "");
    }
}
