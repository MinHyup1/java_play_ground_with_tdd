package com.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    //
    @Test
    void 문자열을_디폴트_구분자_기준으로_분리_한_숫자를_모두_더한다 () {
        //구분자 : 쉼표(,) 또는 콜론(:)

        String value = "1,2,3";
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.plusStringNumbersBySeparator(value);
        assertThat(result).isEqualTo(6);

        String value2= "1,2:3";
        int result2 = stringCalculator.plusStringNumbersBySeparator(value);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    void 문자열을_선택한_구분자_기준으로_분리_한_숫자를_모두_더한다 () {
        //구분자 : “//;\n" -> ";"
        String value = "//;\n1;2;3";
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.plusStringNumbersBySeparator(value);
        assertThat(result).isEqualTo(6);
    }
}
