package com.example.farm.calculator.service;

import com.example.farm.calculator.dto.CalculateRequestDto;
import com.example.farm.calculator.dto.CalculateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {


    public CalculateResponseDto calculate(CalculateRequestDto requestDto) {

        CalculateResponseDto calculateResponseDto = new CalculateResponseDto();
        double earningPerMachine = (requestDto.getProductSellingPrice() / 396.0) * (5 + requestDto.getIncreaseByLabor());   // 타임기 1대 판매가
        earningPerMachine -= 900;   // 제작비
        earningPerMachine -= requestDto.getLaborCost() / 5;     // 품 알바비
        earningPerMachine -= requestDto.getMineralPurchasePrice() / 396.0 * 15;       // 고미 가격
        earningPerMachine -= requestDto.getTimeMaterialPurchasePrice() / 396.0 * 5;   // 시균 가격

        calculateResponseDto.setEarningPerMachine((int)earningPerMachine);
        calculateResponseDto.setTotalEarning((int)earningPerMachine * requestDto.getTotalMachine());

        return calculateResponseDto;
    }

}
