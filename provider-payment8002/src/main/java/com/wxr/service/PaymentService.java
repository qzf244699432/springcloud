package com.wxr.service;


import com.wxr.domain.Payment;

public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
