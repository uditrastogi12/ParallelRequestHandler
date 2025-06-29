package com.billingms.service;

import com.billingms.model.ClientQuota;
import com.billingms.repository.ClientQuotaRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingService {

    private final ClientQuotaRepository quotaRepository;

    public BillingService(ClientQuotaRepository quotaRepository) {
        this.quotaRepository = quotaRepository;
    }

    @Transactional
    public boolean validateAndConsume(String clientId) {
        try {
            ClientQuota quota = quotaRepository.findById(clientId)
                    .orElseThrow(() -> new RuntimeException("Client not found: " + clientId));

            if (quota.getBalance() <= 0) {
                return false; // insufficient balance
            }

            quota.setBalance(quota.getBalance() - 1);
            quotaRepository.save(quota); // optimistic lock 

            return true;

        } catch (OptimisticLockingFailureException e) {
            
            return false;
        }
    }




 
}
