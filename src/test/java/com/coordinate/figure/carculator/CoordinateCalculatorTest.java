package com.coordinate.figure.carculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//jh. 모든 계산기가 CoordinateCalculator를 구현하고 있긴 하지만, 각 구현체 별로 테스트 파일을 분리해 주시면 테스트를 읽기가 더 편할 것 같습니다.
class CoordinateCalculatorTest {

    @ParameterizedTest // jh. 오.. 수식 결과에 대한 검증을 테스트를 읽는 사람에게 어떻게 깔끔하게 전달할 수 있을지 고민했었는데 이 방법 되게 직관적으로 와닿았어요
    @CsvSource(value = {"(0,0)-(5,0):5","(0,1)-(1,2):1.4142","(10,10)-(15,15):7.0710","(0,0)-(0,0):0","(0,0)-(24,24):33.9411"}, delimiter = ':')
    void 주어진_두개의_좌표로_직선거리를_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        LineCalculator lineCalculator = new LineCalculator(); // jh. when 은 이 테스트가 검증하려는 동작을 명시하는 부분이다 보니, 20번 라인까지 given에 포함시키고
        double distance = lineCalculator.calculate(coordinatesToString); // 21번 라인만 when에 두어서 calculate을 검증하겠다는 걸 명확히 하는 게 좋겠다는 생각이 들었습니다.

        //then
        assertThat(distance).isEqualTo(expected, offset(0.00099));
    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(5,0)-(1,2):5"}, delimiter = ':')
    void 세게의_좌표는_직선거리계산기를_이용할_수_없다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        LineCalculator lineCalculator = new LineCalculator();
        /*
         jh.
         사용자가 좌표를 몇 개 입력할지 모르는 상태에서 어떤 도형의 계산기를 생성해야할지 판단할 수는 없다고 생각합니다.
         좌표의 개수를 인식한 후에 동적으로 계산기를 생성할 수 있다고 생각하는데, '좌표 개수 체크' 후 그에 맞는 '계산기 생성' 기능을 담당할 클래스를 따로 두는 건 어떨까요?
         그 클래스랑 CoordinateCalculator 타입 계층을 활용하면 좌표 개수가 늘어나도 코드를 유연하게 변경할 수 있을 것 같다고 생각합니다.
         */

        //then
        assertThatThrownBy(() -> {
            double distance = lineCalculator.calculate(coordinatesToString);
        }).isInstanceOf(RuntimeException.class);


    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(0,4)-(4,0)-(4,4):16","(0,0)-(0,5)-(4,0)-(4,5):20"}, delimiter = ':')
    void 주어진_네개의_좌표로_직사각형_면젹을_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        RectangleCalculator rectangleCalculator = new RectangleCalculator();
        double area = rectangleCalculator.calculate(coordinatesToString);

        //then
        assertThat(area).isEqualTo(expected, offset(0.00099));
    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(0,0)-(0,0)-(0,0):0","(1,0)-(2,5)-(5,0)-(24,5):99"}, delimiter = ':')
    void 주어진_네개의_좌표가_직사각형이_아니라면_예외가_발생한다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        RectangleCalculator rectangleCalculator = new RectangleCalculator();

        //then
        assertThatThrownBy(() -> {
            double area = rectangleCalculator.calculate(coordinatesToString);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(0,4)-(4,4):8"}, delimiter = ':')
    void 주어진_네개의_좌표로_삼각형의_면젹을_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        double area = triangleCalculator.calculate(coordinatesToString);

        //then
        assertThat(area).isEqualTo(expected, offset(0.00099));
    }
}
