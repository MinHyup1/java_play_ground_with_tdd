package com.racingcar;

import com.racingcar.domain.Car;
import com.racingcar.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    // 이런것 까지 TDD 로 해야하는지 싶다

    @Test
    @DisplayName("자동차이름이 , 로 구분된 자동차 일급 컬렉션을 생성할 수 있다.")
    void 자동차이름_목록_문자열을_일급컬렉션으로_생성할_수_있다() {
        String carNames = "one,two,three,four";
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCarList();
        assertThat(carList).contains(new Car("one"), new Car("two"), new Car("three"), new Car("four"));
    }

    @Test
    @DisplayName("자동차의 위치값을 랜덤으로 4이상 9이하의 값으로 전진할 수 있다.")
    void 자동차의_위차값을_전진할_수_있다() {
        Car car = new Car("car");
        int carLocationBeforeMove = car.getLocation();
        car.moveForward();
        int carLocationAfterMove = car.getLocation();
        assertThat(carLocationBeforeMove).isLessThan(carLocationAfterMove);
    }
}
