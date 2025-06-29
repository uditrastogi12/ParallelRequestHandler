package com.esignms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsageRecordRequest {
    private String clientId;
    private int unitsUsed;
}
