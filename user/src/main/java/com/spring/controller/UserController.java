package com.spring.controller;/**
 * Created by sunxueyan on 2020/5/8.
 */

import com.spring.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/5/8
 * @Version V1.0
 **/
@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getPower.do")
    public R getPower(){
        return R.success("操作成功", restTemplate.getForObject("http://localhost:6000/getPower.do",Object.class));
    }

}
