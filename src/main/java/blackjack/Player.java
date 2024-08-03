package blackjack;

import java.util.Objects;

public class Player {

    private final String name;
    private Integer betAmount;

    private Player(String name, Integer betAmount) {
        Objects.requireNonNull(name, "name");
        if (betAmount == null || betAmount <= 0) {
            throw new IllegalArgumentException("betAmount");
        }

        this.name = name;
        this.betAmount = betAmount;
    }

    private Player(String name) {
        Objects.requireNonNull(name, "name");
        this.name = name;
    }

    public static Player dealer() {
        return new Player("딜러");
    }

    public static Player participant(String name, int betAmount) {
        return new Player(name, betAmount);
    }

    public String getName() {
        return this.name;
    }

    public Integer getBetAmount() {
        return this.betAmount;
    }
}
