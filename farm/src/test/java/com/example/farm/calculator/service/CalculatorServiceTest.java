package com.example.farm.calculator.service;

import com.example.farm.calculator.dto.CalculateRequestDto;
import com.example.farm.calculator.dto.CalculateResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @DisplayName("입력 값을 받아 타임팜 순이익을 계산하여 반환한다.")
    @Test
    void calculatorTest() {
        // given
        CalculateRequestDto calculateRequestDto = new CalculateRequestDto();
        calculateRequestDto.setLaborCost(300000);
        calculateRequestDto.setIncreaseByLabor(5);
        calculateRequestDto.setMineralPurchasePrice(35000000);
        calculateRequestDto.setTimeMaterialPurchasePrice(35000000);
        calculateRequestDto.setProductSellingPrice(100000000);
        calculateRequestDto.setTotalMachine(1);

        // when
        CalculateResponseDto calculate = calculatorService.calculate(calculateRequestDto);

        // then
        assertThat(calculate.getEarningPerMachine()).isEqualTo(696675);
        assertThat(calculate.getTotalEarning()).isEqualTo(696675);
    }

    @DisplayName("입력 값을 받아 타임팜 순이익을 계산하여 반환한다.")
    @Test
    void calculatorTest2() {
        // given
        CalculateRequestDto calculateRequestDto = new CalculateRequestDto();
        calculateRequestDto.setLaborCost(300000);
        calculateRequestDto.setIncreaseByLabor(5);
        calculateRequestDto.setMineralPurchasePrice(30000000);
        calculateRequestDto.setTimeMaterialPurchasePrice(30000000);
        calculateRequestDto.setProductSellingPrice(80000000);
        calculateRequestDto.setTotalMachine(5);

        // when
        CalculateResponseDto calculate = calculatorService.calculate(calculateRequestDto);

        // then
        assertThat(calculate.getEarningPerMachine()).isEqualTo(444150);
        assertThat(calculate.getTotalEarning()).isEqualTo(2220750);
    }



}
