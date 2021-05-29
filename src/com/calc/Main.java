package com.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final String outputFormat = "%f EUR to %f %s";

    public static void main(String[] args) {
        HashMap<String, Float> currencyRates = null;
        try {
            currencyRates = XMLParser.parse();
        } catch (IOException e) {
            System.err.print("Database file not found.");
            System.exit(1);
        }

	    CurrencyCalculator calculator = new CurrencyCalculator(currencyRates);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz q, żeby wyjść");
        while (true) {

            System.out.print("Wpisz na jaką walutę przekonwertować: ");
            String currency = scanner.nextLine();

            if (currency.equals("q")) break;

            System.out.print("Wpisz wartość EUR: ");
            float inputValue = scanner.nextFloat();
            scanner.nextLine();

            float result = 0.0f;
            try {
                result = calculator.calculate(currency, inputValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Currency not supported");
                continue;
            }

            System.out.printf((outputFormat) + "%n", inputValue, result, currency);
        }

    }
}
