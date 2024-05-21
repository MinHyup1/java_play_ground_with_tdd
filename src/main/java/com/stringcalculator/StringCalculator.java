package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String DEFAULT_SEPARATOR = "[,:]";

    // default 구분자 쉼표(,) , 콜론(:)
    // while 문을 돌며 구분자가 존재하는지 확인하고

    public int plusStringNumbersBySeparator(String value) {
        // 패턴 컴파일
        Pattern compiledPattern = Pattern.compile(DEFAULT_SEPARATOR);

        // 입력 문자열에 패턴 매칭
        Matcher matcher = compiledPattern.matcher(value);

        if(matcher.find()) {
            return pushIntegerList(splitIntegerByDefaultSeparator(value));
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
    private List<Integer> splitIntegerByDefaultSeparator(String value) {
        List<Integer> result = new ArrayList<>();
        for (String s : value.split(DEFAULT_SEPARATOR)) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
