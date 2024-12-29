package black_jack;

import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;

import java.util.Random;

public class Card {
    private CardSuitType suitType;
    private CardRankType rankType;

    public Card(CardSuitType suitType, CardRankType rankType) {
        this.suitType = suitType;
        this.rankType = rankType;
    }

    public static Card getRandomCard() {
        return new Card(getRandomCardSuitType(),getRandomCardRankType());
    }

    private static CardSuitType getRandomCardSuitType() {
        CardSuitType[] suits = CardSuitType.values();
        int randomIndex = new Random().nextInt(suits.length);
        return suits[randomIndex];
    }

    private static CardRankType getRandomCardRankType() {
        CardRankType[] rank = CardRankType.values();
        int randomIndex = new Random().nextInt(rank.length);
        return rank[randomIndex];
    }

    public Integer getRank() {
        return rankType.getValue();
    }

    @Override
    public String toString() {
        return rankType.getCardName() + suitType.getName();
    }
}
