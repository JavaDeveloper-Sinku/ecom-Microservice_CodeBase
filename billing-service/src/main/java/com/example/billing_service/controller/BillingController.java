package com.example.billing_service.controller;


import com.example.billing_service.dto.BillResponse;
import com.example.billing_service.dto.CreateBillRequest;
import com.example.billing_service.entity.Bill;
import com.example.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

   @PostMapping("/create")
    public BillResponse createBill(
           @RequestBody CreateBillRequest request
           ){
       return billingService.createBill(request);

   }

   @GetMapping("/{billId}")
    public BillResponse getBill(@PathVariable String billId){
       return billingService.getBill(billId);

   }

   @GetMapping
    public String healthCheck(){

       return " 2026-01-25T14:13:08.825+05:30  INFO 26493 --- [billing-service] [nio-8080-exec-5] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms\n" +
               "Application started in 8080 port";
   }

}
