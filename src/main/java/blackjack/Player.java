package blackjack;

import java.util.Objects;

public class Player {

    //todo 인스턴스 변수 3개 미만으로 유지
    private final String name;
    private Integer betAmount;
    private final CardDeck cardDeck;
    private boolean proceeding;

    private Player(String name, Integer betAmount, CardDeck cardDeck, boolean proceeding) {
        Objects.requireNonNull(name, "name");
        if (betAmount == null || betAmount <= 0) {
            throw new IllegalArgumentException("betAmount");
        }
        Objects.requireNonNull(cardDeck, "cardDeck");

        this.name = name;
        this.betAmount = betAmount;
        this.cardDeck = cardDeck;
        this.proceeding = proceeding;
    }

    private Player(String name, CardDeck cardDeck, boolean proceeding) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(cardDeck, "cardDeck");
        this.name = name;
        this.cardDeck = cardDeck;
        this.proceeding = proceeding;
    }

    public static Player dealer(CardDeck cardDeck, boolean proceeding) {
        return new Player("딜러", cardDeck, proceeding);
    }

    public static Player participant(String name, int betAmount, CardDeck cardDeck, boolean proceeding) {
        return new Player(name, betAmount, cardDeck, proceeding);
    }

    public String getName() {
        return this.name;
    }

    public Integer getBetAmount() {
        return this.betAmount;
    }

    public boolean addCard(Card card) {
        Objects.requireNonNull(card, "card");
        return this.cardDeck.addCard(card);
    }

    public boolean isProceeding() {
        return this.proceeding;
    }

    public String getCardPrint() {
        return this.cardDeck.toString();
    }

    public Integer totalCardPoint() {
        return cardDeck.countUpScore();
    }

    public void draw() {
        this.betAmount += (int) Math.round((betAmount * 0.5));
        this.proceeding = false;
    }
}
