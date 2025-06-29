// controller/BillingController.java
package com.billingms.controller;

import com.billingms.dto.BalanceCheckRequest;
import com.billingms.dto.UsageRecordRequest;
import com.billingms.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;


    @PostMapping("/validate-consume")
    public String validateAndConsume(@RequestParam String clientId) {
        boolean result = billingService.validateAndConsume(clientId);
        return result ? "Allowed" : "Rejected";
    }

   


}

