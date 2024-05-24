package com.racingcar;

public class CarName {

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty() || trimmedName.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
        }
    }
}
