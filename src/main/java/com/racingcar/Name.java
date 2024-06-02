package com.racingcar;

import java.util.Objects;

public class Name {

    public Name(String name) {
        name = Objects.requireNonNullElse(name, "");
        String trimmedName = name.trim();
        if (trimmedName.length() < 1 || trimmedName.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
        }
    }
}
