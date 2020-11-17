package com.wxr.service;

import com.wxr.domain.CommonResult;
import com.wxr.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymenFeignService {


    @GetMapping(value = "/payment/get/{id}")//去找服务的提供者PAYMENT-SERVICE中的controller中这个地址的payment/get方法
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();

    @GetMapping(value = "/payment1/get/{id}")//去找服务的提供者PAYMENT-SERVICE中的controller中这个地址的payment/get方法
    public CommonResult<Payment> getPaymentById1(@PathVariable("id") Long id);


}
