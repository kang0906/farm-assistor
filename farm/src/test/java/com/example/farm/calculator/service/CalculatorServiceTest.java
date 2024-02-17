package com.example.farm.calculator.service;

import com.example.farm.calculator.dto.CalculateRequestDto;
import com.example.farm.calculator.dto.CalculateResponseDto;
import com.example.farm.calculator.entity.CalculateHistory;
import com.example.farm.calculator.repository.CalculateHistoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculateHistoryRepository calculateHistoryRepository;

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
        CalculateResponseDto calculateResponseDto = calculatorService.calculate(calculateRequestDto);

        // then
        assertThat(calculateResponseDto.getEarningPerMachine()).isEqualTo(696675);
        assertThat(calculateResponseDto.getTotalEarning()).isEqualTo(696675);

        CalculateHistory calculateHistory = calculateHistoryRepository.findAll().get(0);
        assertThat(calculateHistory.getMineralPurchasePrice()).isEqualTo(calculateRequestDto.getMineralPurchasePrice());
        assertThat(calculateHistory.getTimeMaterialPurchasePrice()).isEqualTo(calculateRequestDto.getTimeMaterialPurchasePrice());
        assertThat(calculateHistory.getLaborCost()).isEqualTo(calculateRequestDto.getLaborCost());
        assertThat(calculateHistory.getProductSellingPrice()).isEqualTo(calculateRequestDto.getProductSellingPrice());
        assertThat(calculateHistory.getIncreaseByLabor()).isEqualTo(calculateRequestDto.getIncreaseByLabor());
        assertThat(calculateHistory.getTotalEarning()).isEqualTo(calculateResponseDto.getTotalEarning());
        assertThat(calculateHistory.getEarningPerMachine()).isEqualTo(calculateResponseDto.getEarningPerMachine());
        assertThat(calculateHistory.getCreatedDateTime()).isNotNull();
        assertThat(calculateHistory.getModifiedDateTime()).isNotNull();
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
        CalculateResponseDto calculateResponseDto = calculatorService.calculate(calculateRequestDto);

        // then
        assertThat(calculateResponseDto.getEarningPerMachine()).isEqualTo(444150);
        assertThat(calculateResponseDto.getTotalEarning()).isEqualTo(2220750);

        CalculateHistory calculateHistory = calculateHistoryRepository.findAll().get(0);
        assertThat(calculateHistory.getMineralPurchasePrice()).isEqualTo(calculateRequestDto.getMineralPurchasePrice());
        assertThat(calculateHistory.getTimeMaterialPurchasePrice()).isEqualTo(calculateRequestDto.getTimeMaterialPurchasePrice());
        assertThat(calculateHistory.getLaborCost()).isEqualTo(calculateRequestDto.getLaborCost());
        assertThat(calculateHistory.getProductSellingPrice()).isEqualTo(calculateRequestDto.getProductSellingPrice());
        assertThat(calculateHistory.getIncreaseByLabor()).isEqualTo(calculateRequestDto.getIncreaseByLabor());
        assertThat(calculateHistory.getTotalEarning()).isEqualTo(calculateResponseDto.getTotalEarning());
        assertThat(calculateHistory.getEarningPerMachine()).isEqualTo(calculateResponseDto.getEarningPerMachine());
        assertThat(calculateHistory.getCreatedDateTime()).isNotNull();
        assertThat(calculateHistory.getModifiedDateTime()).isNotNull();
    }



}
