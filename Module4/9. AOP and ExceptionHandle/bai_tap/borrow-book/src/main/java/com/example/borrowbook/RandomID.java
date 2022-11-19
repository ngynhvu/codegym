package com.example.borrowbook;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomID {
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = digits;
    private static final String ALL =digits;

    private static Random generator = new Random();

    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    public String IDBorrow(){
        return randomAlphaNumeric(5);
    }

}
