package blackjack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CardDeck {

    private static final Integer BLACKJACK_POINT = 21;
    private final Set<Card> cards;

    public CardDeck() {
        this.cards = new HashSet<>();
    }

    public int countUpScore() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("no cards");
        }

        int sum = cards.stream()
            .mapToInt(Card::getScore)
            .sum();

        if (21 < sum) {
            boolean aceExists = cards.stream()
                .anyMatch(Card::isAce);
            if (aceExists) {
                return sum - 10;
            }
        }
        return sum;
    }

    public boolean addCard(Card card) {
        Objects.requireNonNull(card, "card");
        return this.cards.add(card);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append(", ");
        }

        sb.delete(sb.lastIndexOf(", "), sb.lastIndexOf(", ") + 1);
        return sb.toString();
    }

    public boolean isBlackjack() {
        return countUpScore() == BLACKJACK_POINT;
    }
}
