package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    // default 구분자 쉼표(,) , 콜론(:)
    // while 문을 돌며 구분자가 존재하는지 확인하고

    public int plusStringNumbersBySeparator(String value) {
        List<Integer> integers = splitIntegerBySeparator(value);

        return pushIntegerList(integers);
    }

    private int pushIntegerList(List<Integer> integers) {
        int result = 0;

        for (Integer number : integers) {
            result += number;
        }
        return result;
    }

    private List<Integer> splitIntegerBySeparator(String value) {
        List<Integer> result = new ArrayList<>();

        if(value.contains(",|:")){
            for (String s : value.split(",")) {
                result.add(Integer.parseInt(s));
            }
        }
        return result;
    }
}
