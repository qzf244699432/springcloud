package com.wxr;


import com.wxr.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PAYMENT-SERVICE",configuration = MySelfRule.class)//针对支付服务，配置自己的规则，并且规则必须是单独的一个包
public class ConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80.class);
    }
}
