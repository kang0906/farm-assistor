package com.example.farm.calculator.controller;

import com.example.farm.calculator.dto.CalculateRequestDto;
import com.example.farm.calculator.dto.CalculateResponseDto;
import com.example.farm.calculator.service.CalculatorService;
import com.example.farm.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/time/calc")
    public ResponseDto<CalculateResponseDto> calculate(@RequestBody CalculateRequestDto requestDto) {

        return ResponseDto.success(calculatorService.calculate(requestDto));
    }
}
