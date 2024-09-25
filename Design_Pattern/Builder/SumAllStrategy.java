package com.nikita.birds.strategies;

import java.util.List;

public class SumAllStrategy implements SumStrategy {
    @Override
    public int calculate(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
