package black_jack;

import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;

import java.util.Random;

public class Card {
    private CardSuitType suitType;
    private CardRankType rankType;

    public Card() {
        this.suitType = getRandomCardSuitType();
        this.rankType = getRandomCardRankType();
    }

    private CardSuitType getRandomCardSuitType() {
        CardSuitType[] suits = CardSuitType.values();
        int randomIndex = new Random().nextInt(suits.length);
        return suits[randomIndex];
    }

    private CardRankType getRandomCardRankType() {
        CardRankType[] rank = CardRankType.values();
        int randomIndex = new Random().nextInt(rank.length);
        return rank[randomIndex];
    }

    public Integer getRank() {
        return rankType.getValue();
    }
}
