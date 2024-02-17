package com.example.farm.calculator.entity;

import com.example.farm.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class CalculateHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calculateHistoryId;

    // request
    private int timeMaterialPurchasePrice;  // 시균 매입가
    private int mineralPurchasePrice;       // 고미 매입가
    private int laborCost;                  // 품 알바비
    private int productSellingPrice;        // 타임 판매가
    private int increaseByLabor;            // 품 개수(손)
    private int totalMachine;               // 타임기 수

    // response
    private int totalEarning;       // 총 순이익
    private int earningPerMachine;  // 타임기 1대당 순이익
}
