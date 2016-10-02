package main;

import java.util.HashMap;
import java.util.Map;


public class NumberConversion {

    Map<Integer, String> wordForNumber = new HashMap<>();
    Map<Integer, NameMultiplierPair> nameMultiplierPairs = new HashMap<>();

    public NumberConversion() {
        initializeMapping();
        setDevidersForNumbers();
    }

    private void setDevidersForNumbers() {
        nameMultiplierPairs.put(2, new NameMultiplierPair("", 10));
        nameMultiplierPairs.put(3, new NameMultiplierPair("Hundred", 100));
        nameMultiplierPairs.put(4, new NameMultiplierPair("Thousand", 1000));
        nameMultiplierPairs.put(5, new NameMultiplierPair("Thousand", 1000));
        nameMultiplierPairs.put(6, new NameMultiplierPair("Lakh", 100000));
        nameMultiplierPairs.put(7, new NameMultiplierPair("Lakh", 100000));
        nameMultiplierPairs.put(8, new NameMultiplierPair("Crore", 10000000));
        nameMultiplierPairs.put(9, new NameMultiplierPair("Crore", 10000000));
    }

    private void initializeMapping() {
        singleDigitNumberMapping();
        doubleDigitNumberMapping();
        tenthNumberMapping();
    }

    private void tenthNumberMapping() {
        wordForNumber.put(10, "Ten");
        wordForNumber.put(20, "Twenty");
        wordForNumber.put(30, "Thirty");
        wordForNumber.put(40, "Fourty");
        wordForNumber.put(50, "Fifty");
        wordForNumber.put(60, "Sixty");
        wordForNumber.put(70, "Seventy");
        wordForNumber.put(80, "Eighty");
        wordForNumber.put(90, "Ninety");
    }

    private void doubleDigitNumberMapping() {
        wordForNumber.put(11, "Eleven");
        wordForNumber.put(12, "Twelve");
        wordForNumber.put(13, "Thirteen");
        wordForNumber.put(14, "Fourteen");
        wordForNumber.put(15, "Fifteen");
        wordForNumber.put(16, "Sixteen");
        wordForNumber.put(17, "Seventeen");
        wordForNumber.put(18, "Eighteen");
        wordForNumber.put(19, "Nineteen");
    }

    private void singleDigitNumberMapping() {
        wordForNumber.put(0, "Zero");
        wordForNumber.put(1, "One");
        wordForNumber.put(2, "Two");
        wordForNumber.put(3, "Three");
        wordForNumber.put(4, "Four");
        wordForNumber.put(5, "Five");
        wordForNumber.put(6, "Six");
        wordForNumber.put(7, "Seven");
        wordForNumber.put(8, "Eight");
        wordForNumber.put(9, "Nine");
    }

    public String toWord(Integer number) {
        if (wordForNumber.containsKey(number))
            return wordForNumber.get(number);
        else {
            Integer divisionResult = number / getDividerForNumber(numberLength(number));
            if (numberBetween20And100(number)) {
                return wordForNumber.get(divisionResult * getDividerForNumber(numberLength(number))) + " " + wordForNumber.get((number - divisionResult * getDividerForNumber(numberLength(number))));
            } else {
                return wordForNumber.get(divisionResult) + " " + getNameForNumber(numberLength(number)) + " " + toWord(number % getDividerForNumber(numberLength(number)));
            }
        }
    }

    private int numberLength(Integer number) {
        return (int) Math.log10(number) + 1;
    }

    private boolean numberBetween20And100(Integer number) {
        return number < 100 && number > 20;
    }

    private String getNameForNumber(int numberlength) {
        return nameMultiplierPairs.get(numberlength).getName();
    }

    private int getDividerForNumber(Integer numberLength) {
        return nameMultiplierPairs.get(numberLength).getMultiplier();
    }
}
