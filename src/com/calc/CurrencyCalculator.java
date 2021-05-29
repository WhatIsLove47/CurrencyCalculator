package com.calc;

import java.util.HashMap;

public class CurrencyCalculator {

    private final HashMap<String, Float> currencyRates;

    public CurrencyCalculator(HashMap<String, Float> currencyRates) {
        this.currencyRates = currencyRates;
    }

    public float calculate(String currency, float value) throws IllegalArgumentException {
        if (currencyRates.containsKey(currency)) {
            return currencyRates.get(currency) * value;
        }
        throw new IllegalArgumentException(currency + " is not supported currency.");
    }
}
