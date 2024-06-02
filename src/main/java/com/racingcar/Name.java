package com.racingcar;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        name = Objects.requireNonNullElse(name, "");
        validate(name);

        this.name = name;
    }

    private static void validate(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() < 1 || trimmedName.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
        }
    }

    public String getName() {
        return name;
    }
}
