package com.spring.controller;/**
 * Created by sunxueyan on 2020/5/8.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PowerController
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/5/8
 * @Version V1.0
 **/
@RestController
public class PowerController {

    @RequestMapping("getPower.do")
    public Object getPower(){
        Map<String, Object> map = new HashMap<>();
        map.put("ket","power");
        return map;
    }
}
