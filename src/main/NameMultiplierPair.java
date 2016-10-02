package main;

public class NameMultiplierPair {
    private final String name;
    private final Integer multiplier;

    public NameMultiplierPair(String name, Integer multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public Integer getMultiplier() {
        return multiplier;
    }
}