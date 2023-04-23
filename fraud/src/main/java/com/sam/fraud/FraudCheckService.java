package com.sam.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@AllArgsConstructor
@Slf4j
@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulent(Integer customerId){
        repository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build() );
        log.info("fraud check complete for customer with Id: {}", customerId);
        return false;
    }
}
