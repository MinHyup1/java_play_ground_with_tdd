package blackjack;

import java.util.Objects;

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

    // todo CardDeck addCard 테스트용으로 임시 추가
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return cardPattern == card.cardPattern;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardPattern);
    }
}
