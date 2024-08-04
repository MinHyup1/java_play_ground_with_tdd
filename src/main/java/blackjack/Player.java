package blackjack;

import java.util.Objects;

public class Player {

    private final String name;
    private Integer betAmount;
    private final CardDeck cardDeck;

    private Player(String name, Integer betAmount, CardDeck cardDeck) {
        Objects.requireNonNull(name, "name");
        if (betAmount == null || betAmount <= 0) {
            throw new IllegalArgumentException("betAmount");
        }
        Objects.requireNonNull(cardDeck, "cardDeck");

        this.name = name;
        this.betAmount = betAmount;
        this.cardDeck = cardDeck;
    }

    private Player(String name, CardDeck cardDeck) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(cardDeck, "cardDeck");
        this.name = name;
        this.cardDeck = cardDeck;
    }

    public static Player dealer(CardDeck cardDeck) {
        return new Player("딜러", cardDeck);
    }

    public static Player participant(String name, int betAmount, CardDeck cardDeck) {
        return new Player(name, betAmount, cardDeck);
    }

    public String getName() {
        return this.name;
    }

    public Integer getBetAmount() {
        return this.betAmount;
    }
}
