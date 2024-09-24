package com.nikita.birds.strategies;

import java.util.List;

public class SumContext {
    private SumStrategy strategy;

    public void setStrategy(SumStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(List<Integer> numbers) {
        return strategy.calculate(numbers);
    }
}
