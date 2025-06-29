package com.esignms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceCheckRequest {
    private String clientId;
}
