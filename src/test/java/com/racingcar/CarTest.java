package com.racingcar;

import com.racingcar.domain.Cars;
import com.racingcar.domain.car.Car;
import com.racingcar.domain.car.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차이름이 , 로 구분된 자동차 일급 컬렉션을 생성할 수 있다.")
    void 자동차이름_목록_문자열을_일급컬렉션으로_생성할_수_있다() {
        String carNames = "one,two,three,four";
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCarList();
        assertThat(carList).contains(new Car("one"), new Car("two"), new Car("three"), new Car("four"));
    }

    @Test
    @DisplayName("4이상의 숫자가 나오면 자동차를 전진 할 수 있다.")
    void 자동차의_위차값을_전진할_수_있다() {
        Car car = new Car("car");
        car.moveOrStopByRandomNumber(4);
        assertThat(car).isEqualTo(new Car("car", new Location(1)));
    }

    @Test
    @DisplayName("우승한 자동차를 선정할 수 있다.")
    void 자동차_일급컬랙션_안에서_우승한_자동차를_가려낼_수_있다() {
        Car one = new Car("one");
        one.moveOrStopByRandomNumber(4);
        one.moveOrStopByRandomNumber(4);
        one.moveOrStopByRandomNumber(4);
        Car two = new Car("two");
        two.moveOrStopByRandomNumber(4);
        two.moveOrStopByRandomNumber(4);
        two.moveOrStopByRandomNumber(1);
        Car three = new Car("three");
        three.moveOrStopByRandomNumber(1);
        three.moveOrStopByRandomNumber(1);
        three.moveOrStopByRandomNumber(4);

        Cars cars = new Cars(List.of(one, two, three));
        List<Car> winners = cars.getWinner();

        assertThat(winners).containsExactly(one);
    }

    @Test
    @DisplayName("우승한 자동차는 2개 이상 일 수 있다.")
    void 자동차_일급컬랙션_안에서_우승한_자동차는_2개_이상일_수_있다() {
        Car one = new Car("one");
        one.moveOrStopByRandomNumber(1);
        Car two = new Car("two");
        two.moveOrStopByRandomNumber(4);
        Car three = new Car("three");
        three.moveOrStopByRandomNumber(4);

        Cars cars = new Cars(List.of(one, two, three));
        List<Car> winners = cars.getWinner();

        assertThat(winners).containsExactly(two,three);
    }
}
