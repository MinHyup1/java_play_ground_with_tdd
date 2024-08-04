package blackjack;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private final List<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public void countUpScore() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("no cards");
        }
    }
}
