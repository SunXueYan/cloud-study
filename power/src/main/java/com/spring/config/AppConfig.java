package com.spring.config;/**
 * Created by sunxueyan on 2020/5/8.
 */

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName AppConfig
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/5/8
 * @Version V1.0
 **/
@Configuration
public class AppConfig {
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String... doYourBest) {
        JavaChallenge2.executeAction3(1);
        JavaChallenge2.executeAction1(1.0);
//        executeAction2(Double.valueOf("5"));
//        executeAction3(1L);

        System.out.println(JavaChallenge2.x);
    }

    @Bean
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(6000);
        return tomcat;
    }
}
