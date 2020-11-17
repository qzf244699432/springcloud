package com.wxr.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Applications;
import com.wxr.domain.CommonResult;
import com.wxr.domain.Payment;
import com.wxr.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymenController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

   /* @Resource
    private DiscoveryClient discoveryClient;//获取注册服务中心的信息*/

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果为：{}",result);
        if(result>0){
            return new CommonResult(200,"创建成功"+serverPort,result);
        }else{
            return new CommonResult(400,"创建失败"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为：{}",payment);
        if(payment==null){
            return new CommonResult(400,"查询失败"+serverPort,null);
        }else{
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }

    }
    /*@GetMapping(value = "/payment/discovery")
    public  Object discovery(){
//        Applications applications = discoveryClient.getApplications();
//        discoveryClient.
        return this.discoveryClient;
    }*/

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return serverPort;
    }


    @GetMapping(value = "/payment1/get/{id}")
    public CommonResult<Payment> getPaymentById1(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为：{}",payment);
        if(payment==null){
            return new CommonResult(400,"查询失败"+serverPort,null);
        }else{
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value ="/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }


}
