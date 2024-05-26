package com.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringUtils {

    public static List<String> separate(String sentence, String separator) {
        Objects.requireNonNull(sentence);
        Objects.requireNonNull(separator);

        String[] words = sentence.split(separator);
        return Arrays.stream(words).toList();
    }

}
