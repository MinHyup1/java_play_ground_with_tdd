package black_jack;


import java.util.ArrayList;
import java.util.List;

/**
 *  카드 일급 컬렉션
 */
public class Cards {
    private List<Card> cards = new ArrayList<Card>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public Integer getTotalRank() {
        return cards.stream().mapToInt(Card::getRank).sum();
    }
}
