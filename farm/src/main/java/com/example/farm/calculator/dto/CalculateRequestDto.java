package com.example.farm.calculator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRequestDto {

    private int timeMaterialPurchasePrice;  // 시균 매입가
    private int mineralPurchasePrice;       // 고미 매입가
    private int laborCost;                  // 품 알바비
    private int productSellingPrice;        // 타임 판매가
    private int increaseByLabor;            // 품 개수(손)
    private int totalMachine;               // 타임기 수
}
