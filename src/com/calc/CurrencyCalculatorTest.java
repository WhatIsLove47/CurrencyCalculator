package com.calc;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyCalculatorTest {

    private static CurrencyCalculator currencyCalculator;

    @BeforeAll
    public static void init() throws IOException {
        currencyCalculator = new CurrencyCalculator(XMLParser.parse());
    }

    @org.junit.jupiter.api.Test
    void calculate_1() {
        float result = currencyCalculator.calculate("PLN", 12);
        assertEquals(53.804398f, result);
    }

    @org.junit.jupiter.api.Test
    void calculate_2() {
        float result = currencyCalculator.calculate("GBP", 12);
        assertEquals(10.328159f, result);
    }

    @org.junit.jupiter.api.Test
    void calculate_3() {
        float result = currencyCalculator.calculate("CHF", 12);
        assertEquals(13.160399f, result);
    }

    @org.junit.jupiter.api.Test
    void calculate_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
                currencyCalculator.calculate("BTC", 12);
        });
    }
}