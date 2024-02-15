package com.example.farm.calculator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateResponseDto {
    private int totalEarning;       // 총 순이익
    private int earningPerMachine;  // 타임기 1대당 순이익
}
