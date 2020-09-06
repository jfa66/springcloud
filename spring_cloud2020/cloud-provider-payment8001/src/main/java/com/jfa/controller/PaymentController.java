package com.jfa.controller;

import com.jfa.entities.CommonResult;
import com.jfa.entities.Payment;
import com.jfa.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        if(result>-1){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(400,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"数据查询成功",payment);
        }else {
            return new CommonResult(400,"数据查询失败或为空",null);
        }
    }
}
