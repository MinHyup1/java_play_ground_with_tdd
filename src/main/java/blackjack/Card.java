package blackjack;

public class Card {

    private CardPattern cardPattern;

    public Card(CardPattern cardPattern) {
        this.cardPattern = cardPattern;
    }

    public int getScore() {
        return cardPattern.score;
    }

    public boolean isAce() {
        return cardPattern.isAce();
    }
}
