// controller/EsignController.java
package com.esignms.controller;

import com.esignms.dto.EsignRequest;
import com.esignms.service.EsignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esign")
@RequiredArgsConstructor
public class EsignController {

    private final EsignService esignService;

    @PostMapping("/do-esign")
    public ResponseEntity<String> doEsign(@RequestBody EsignRequest request) {
        String result = esignService.performEsign(request.getClientId());
        return ResponseEntity.ok(result);
    }
}
