package com.billingms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "client_quotas")
public class ClientQuota {
    @Id
    private String clientId;

    @Version
    private Long version;

    private int balance;
}
