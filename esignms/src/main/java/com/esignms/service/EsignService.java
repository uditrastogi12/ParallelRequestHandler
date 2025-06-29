// service/EsignService.java
package com.esignms.service;

import com.esignms.client.BillingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EsignService {

    private final BillingClient billingClient;

    public String performEsign(String clientId) {
        boolean allowed = billingClient.validateBalance(clientId);
        if (!allowed) {
            return "Insufficient balance. E-sign not allowed.";
        }

        // 
        try {
            Thread.sleep(500); // Placeholder
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Record usage
        billingClient.recordUsage(clientId, 1);

        return "E-sign completed and usage recorded.";
    }
}



