package blackjack;

import java.util.HashSet;
import java.util.Set;

public class CardDeck {

    private final Set<Card> cards;

    public CardDeck() {
        this.cards = new HashSet<>();
    }

    public void countUpScore() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("no cards");
        }
    }

    public boolean addCard(Card card) {
        return this.cards.add(card);
    }
}
