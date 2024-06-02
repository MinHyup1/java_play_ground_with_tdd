package com.racingcar;

import java.util.Objects;

public class Position {

    private static final int MAX_POSITION = 5;

    private int position;

    public Position(int position) {
        if (position < 0 || position > 5) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. 0이상 5이하의 값을 입력해주세요.");
        }

        this.position = position;
    }

    public boolean isLessThan(Position theOther) {
        Objects.requireNonNull(theOther);

        return this.position < theOther.position;
    }

    public Position next() {
        if (position == MAX_POSITION) {
            throw new IllegalStateException("이미 최대 Position에 도달하여 이동할 수 없습니다.");
        }
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
