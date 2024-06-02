package com.racingcar;

import java.util.Objects;

public class Position {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 5;

    public static final Position MAX = new Position(MAX_POSITION);

    private int position;

    public Position(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            String message = String.format("유효하지 않은 값입니다. %d이상 %d이하의 값을 입력해주세요.", MIN_POSITION, MAX_POSITION);
            throw new IllegalArgumentException(message);
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

    public int getPosition() {
        return position;
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
