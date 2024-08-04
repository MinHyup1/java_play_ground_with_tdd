package black_jack.constant.user;

import black_jack.Card;
import black_jack.Cards;

public class BlackJackPlayer {

    protected String name; // 플레이어명
    protected Cards cards; // 보유 카드
    private Integer profit; // 수익

    public void drawCard(Card card) {
        cards.addCard(card);
    }

    public Integer getTotalRank() {
        //TODO 에이스가 나왔을경우 1로쓸지 11로 쓸지 결정하는 로직이 있어야함
        return cards.getTotalRank();
    }

    public String getCardsToString() {
        return cards.toString();
    }

    public String getName() {
        return this.name;
    }
}
