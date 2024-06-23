package com.coordinate_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public static int[] getCoordinates() throws IOException {
        System.out.println("좌표를 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if ("Q".equals(input)) {
            System.out.println("종료합니다");
            return new int[]{9999};
        }

        validateFormat(input);
        return extractNumbers(input);
    }

    private static int[] extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        // 정규 표현식 패턴: 숫자
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(number);
        }

        // List를 int 배열로 변환
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }

    private static void validateFormat(String input) {
        // 정규 표현식 패턴: (숫자,숫자) 또는 (숫자,숫자)-(숫자,숫자)
        String setPattern = "\\(\\d+,\\d+\\)";
        String fullPattern = setPattern + "(-" + setPattern + "){1,}";

        Pattern pattern = Pattern.compile(fullPattern);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
