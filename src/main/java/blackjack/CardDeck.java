package blackjack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CardDeck {

    private final Set<Card> cards;

    public CardDeck() {
        this.cards = new HashSet<>();
    }

    public int countUpScore() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("no cards");
        }

        return cards.stream()
            .mapToInt(Card::getScore)
            .sum();
    }

    public boolean addCard(Card card) {
        Objects.requireNonNull(card, "card");
        return this.cards.add(card);
    }
}
