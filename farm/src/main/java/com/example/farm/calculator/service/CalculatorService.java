package com.example.farm.calculator.service;

import com.example.farm.calculator.dto.CalculateRequestDto;
import com.example.farm.calculator.dto.CalculateResponseDto;
import com.example.farm.calculator.entity.CalculateHistory;
import com.example.farm.calculator.repository.CalculateHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CalculatorService {

    private final CalculateHistoryRepository calculateHistoryRepository;

    @Transactional
    public CalculateResponseDto calculate(CalculateRequestDto requestDto) {
        requestDto.checkNumericRangeAndSetAvailable();

        CalculateResponseDto calculateResponseDto = new CalculateResponseDto();
        double earningPerMachine = (requestDto.getProductSellingPrice() / 396.0) * (5 + requestDto.getIncreaseByLabor());   // 타임기 1대 판매가
        earningPerMachine -= 900;   // 제작비
        earningPerMachine -= requestDto.getLaborCost() / 5;     // 품 알바비
        earningPerMachine -= requestDto.getMineralPurchasePrice() / 396.0 * 15;       // 고미 가격
        earningPerMachine -= requestDto.getTimeMaterialPurchasePrice() / 396.0 * 5;   // 시균 가격

        calculateResponseDto.setEarningPerMachine((int)earningPerMachine);
        calculateResponseDto.setTotalEarning((int)earningPerMachine * requestDto.getTotalMachine());

        saveHistory(requestDto, calculateResponseDto.getEarningPerMachine(), calculateResponseDto.getTotalEarning());

        return calculateResponseDto;
    }

    private void saveHistory(CalculateRequestDto requestDto, int earningPerMachine, int totalEarning) {
        CalculateHistory calculateHistory = CalculateHistory.builder()
                .mineralPurchasePrice(requestDto.getMineralPurchasePrice())
                .timeMaterialPurchasePrice(requestDto.getTimeMaterialPurchasePrice())
                .laborCost(requestDto.getLaborCost())
                .productSellingPrice(requestDto.getProductSellingPrice())
                .increaseByLabor(requestDto.getIncreaseByLabor())
                .totalMachine(requestDto.getTotalMachine())
                .earningPerMachine(earningPerMachine)
                .totalEarning(totalEarning)
                .build();

        calculateHistoryRepository.save(calculateHistory);
    }

}
