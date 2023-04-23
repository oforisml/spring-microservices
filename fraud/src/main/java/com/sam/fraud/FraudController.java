package com.sam.fraud;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;


    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulent = fraudCheckService.isFraudulent(customerId);

        log.info("fraud check for customer {}", customerId);
        return new FraudCheckResponse(isFraudulent);

    }

}
