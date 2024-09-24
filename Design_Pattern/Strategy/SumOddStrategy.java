package com.nikita.birds.strategies;

import java.util.List;

public class SumOddStrategy implements SumStrategy {
    @Override
    public int calculate(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
    }
}
