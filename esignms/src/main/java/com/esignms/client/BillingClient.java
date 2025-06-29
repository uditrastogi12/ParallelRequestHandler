package com.esignms.client;


import com.esignms.dto.BalanceCheckRequest;
import com.esignms.dto.UsageRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
@RequiredArgsConstructor
public class BillingClient {

    private final WebClient.Builder webClientBuilder;

    @Value("${billing.base-url}")
    private String billingBaseUrl;

    public boolean validateBalance(String clientId) {
        return webClientBuilder.build()
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path("/validate-consume")
                        .queryParam("clientId", clientId)
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
    

    public void recordUsage(String clientId, int unitsUsed) {
        webClientBuilder.build()
                .post()
                .uri(billingBaseUrl + "/record-usage")
                .bodyValue(new UsageRecordRequest(clientId, unitsUsed))
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}

