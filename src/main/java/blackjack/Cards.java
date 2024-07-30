package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<Card> cards = new ArrayList<>();

    public Cards() {
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int addUp() {
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

}
