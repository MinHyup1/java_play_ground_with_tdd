package black_jack.constant.user;

import black_jack.Card;
import black_jack.Cards;

public class BlackJackPlayer {

    protected Cards cards; // 보유 카드
    private Integer profit; // 수익

    public void drawCard() {
        cards.addCard(new Card());
    }

    public Integer getTotalRank() {
        return cards.getTotalRank();
    }
}
