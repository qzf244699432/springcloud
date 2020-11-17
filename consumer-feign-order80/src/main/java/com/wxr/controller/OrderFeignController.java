package com.wxr.controller;

import com.wxr.domain.CommonResult;
import com.wxr.domain.Payment;
import com.wxr.service.PaymenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymenFeignService paymenFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymenFeignService.getPaymentById(id);

    }

    @GetMapping("/consumer/payment/feign/timeout")
    //openfeign 默认只是等待1秒
    public String paymentFeignTimeOut(){
        return paymenFeignService.paymentFeignTimeOut();
    }

    @GetMapping("/consumer/payment1/get/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id){
        return paymenFeignService.getPaymentById1(id);

    }

}
