package com.billingms.dto;

import lombok.Data;

@Data
public class UsageRecordRequest {
    private String clientId;
    private int unitsUsed;
}