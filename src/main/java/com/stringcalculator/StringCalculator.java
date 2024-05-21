package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String DEFAULT_SEPARATOR = "[,:]";


    public int plusStringNumbersBySeparator(String value) {

        // 커스텀 구분자 //[구분자]\n -> [구분자]
        final Matcher customMatcher = Pattern.compile("//(.)\n(.*)").matcher(value);
        if(customMatcher.find()) {
            return pushIntegerList(splitIntegerByDefaultSeparator(customMatcher.group(2),customMatcher.group(1)));
        }

        // 기본 구분자 -> 쉼표(,) , 콜론(:)
        final Matcher defalutMatcher = Pattern.compile(DEFAULT_SEPARATOR).matcher(value);
        if(defalutMatcher.find()) {
            return pushIntegerList(splitIntegerByDefaultSeparator(value,DEFAULT_SEPARATOR));
        }

        throw new RuntimeException();
    }

    private int pushIntegerList(List<Integer> integers) {
        int result = 0;
        for (Integer number : integers) {
            result += number;
        }
        return result;
    }
    private List<Integer> splitIntegerByDefaultSeparator(String value, String separator) {
        List<Integer> result = new ArrayList<>();
        for (String s : value.split(separator)) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
