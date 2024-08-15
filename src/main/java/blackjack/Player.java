package blackjack;

import java.util.Objects;

public class Player {

    //todo 인스턴스 변수 3개 미만으로 유지
    private final String name;
    private int betAmount;
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
        this.proceeding = false;
    }

    public boolean gotBlackjack() {
        return cardDeck.isBlackjack();
    }

    public void win() {
        this.betAmount += (int) Math.round(this.betAmount * 0.5);
        this.proceeding = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void lose() {
        this.proceeding = false;
        this.betAmount = 0;
    }

    public void minusBetAmount(int winnersBetAmounts) {
        this.betAmount -= winnersBetAmounts; // todo betAmount Integer -> int
    }

    public void plusBetAmount(int losersBetAmounts) {
        this.betAmount += losersBetAmounts;
    }
}
