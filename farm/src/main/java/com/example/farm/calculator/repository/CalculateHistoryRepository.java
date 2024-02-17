package com.example.farm.calculator.repository;

import com.example.farm.calculator.entity.CalculateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculateHistoryRepository extends JpaRepository<CalculateHistory, Long> {
}
