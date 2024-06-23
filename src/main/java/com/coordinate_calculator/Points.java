package com.coordinate_calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * todo 처음엔 도형별 좌표 유효성 검사를 맡기려고 Points 일급 컬렉션을 만든 거였는데
 *  도형별 유효성 검사를 Points에게 맡기니까 오히려 불편하다..
 *  Coordinates 정도만 있어도 충분할 것 같고 Points는 제거하는 게 더 나아보인다.
 */
public class Points {

    private final List<Point> points;

    public Points(int ...values) {
        Objects.requireNonNull(values);

        if (values.length % 2 == 1) {
            throw new IllegalArgumentException("좌표가 잘못 입력되었습니다.");
        }

        if (values.length == 8) {
            validateRectangle(values);

            this.points = Arrays.stream(values)
            .mapToObj(Point::new)
            .collect(Collectors.toList());
            return;
        }

        if (values.length == 4) {
            validateLine(values);
            this.points = Arrays.stream(values)
                .mapToObj(Point::new)
                .collect(Collectors.toList());
            return;
        }

        if (values.length == 6) {
            validateTriangle(values);
            this.points = Arrays.stream(values)
                .mapToObj(Point::new)
                .collect(Collectors.toList());
            return;
        }

        throw new IllegalArgumentException("???");
    }

    private void validateTriangle(int[] values) {
        long uniqueValueCnt = Arrays.stream(values)
            .boxed()
            .collect(Collectors.toSet())
            .stream()
            .count();

        //todo 삼각형 좌표에 대한 검사 로직
    }

    private void validateLine(int[] values) {
        long uniqueValueCnt = Arrays.stream(values)
            .boxed()
            .collect(Collectors.toSet())
            .stream()
            .count();

        if (uniqueValueCnt < 2) {
            throw new IllegalArgumentException("서로 다른 좌표를 입력해주세요.");
        }
    }

    /**
     * 좌표 일급컬렉션으로 변환
     * @return 좌표 일급컬렉션
     */
    public Coordinates toCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < points.size(); i += 2) {
            coordinates.add(new Coordinate(points.get(i), points.get(i + 1)));
        }
        return new Coordinates(coordinates);
    }

    private static void validateRectangle(int[] values) {
        long uniqueValueCnt = Arrays.stream(values)
            .boxed()
            .collect(Collectors.toSet())
            .stream()
            .count();

        if (uniqueValueCnt != 2) {
            throw new IllegalArgumentException("직사각형 면적만 계산할 수 있습니다.");
        }
    }
}
