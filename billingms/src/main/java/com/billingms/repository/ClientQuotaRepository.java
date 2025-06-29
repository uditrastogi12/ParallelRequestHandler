package com.billingms.repository;

import com.billingms.model.ClientQuota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientQuotaRepository extends JpaRepository<ClientQuota, String> {
}