package com.nikita.birds.strategies;

import java.util.List;

public class SumPrimeStrategy implements SumStrategy {
    @Override
    public int calculate(List<Integer> numbers) {
        return numbers.stream().filter(this::isPrime).mapToInt(Integer::intValue).sum();
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
