package blackjack;

import java.util.Arrays;
import java.util.Random;

public enum Card {

    SPADE_TWO("2스페이드", 2),
    SPADE_THREE("3스페이드", 3),
    SPADE_FOUR("4스페이드", 4),
    SPADE_FIVE("5스페이드", 5),
    SPADE_SIX("6스페이드", 6),
    SPADE_SEVEN("7스페이드", 7),
    SPADE_EIGHT("8스페이드", 8),
    SPADE_NINE("9스페이드", 9),
    SPADE_TEN("10스페이드", 10),
    SPADE_KING("K스페이드", 10),
    SPADE_QUEEN("Q스페이드", 10),
    SPADE_JACK("J스페이드", 10),
    SPADE_ACE("A스페이드", 11),

    DIAMOND_TWO("2다이아몬드", 2),
    DIAMOND_THREE("3다이아몬드", 3),
    DIAMOND_FOUR("4다이아몬드", 4),
    DIAMOND_FIVE("5다이아몬드", 5),
    DIAMOND_SIX("6다이아몬드", 6),
    DIAMOND_SEVEN("7다이아몬드", 7),
    DIAMOND_EIGHT("8다이아몬드", 8),
    DIAMOND_NINE("9다이아몬드", 9),
    DIAMOND_TEN("10다이아몬드", 10),
    DIAMOND_KING("K다이아몬드", 10),
    DIAMOND_QUEEN("Q다이아몬드", 10),
    DIAMOND_JACK("J다이아몬드", 10),
    DIAMOND_ACE("A다이아몬드", 11),

    HEART_TWO("2하트", 2),
    HEART_THREE("3하트", 3),
    HEART_FOUR("4하트", 4),
    HEART_FIVE("5하트", 5),
    HEART_SIX("6하트", 6),
    HEART_SEVEN("7하트", 7),
    HEART_EIGHT("8하트", 8),
    HEART_NINE("9하트", 9),
    HEART_TEN("10하트", 10),
    HEART_KING("K하트", 10),
    HEART_QUEEN("Q하트", 10),
    HEART_JACK("J하트", 10),
    HEART_ACE("A하트", 11),

    CLOVER_TWO("2클로버", 2),
    CLOVER_THREE("3클로버", 3),
    CLOVER_FOUR("4클로버", 4),
    CLOVER_FIVE("5클로버", 5),
    CLOVER_SIX("6클로버", 6),
    CLOVER_SEVEN("7클로버", 7),
    CLOVER_EIGHT("8클로버", 8),
    CLOVER_NINE("9클로버", 9),
    CLOVER_TEN("10클로버", 10),
    CLOVER_KING("K클로버", 10),
    CLOVER_QUEEN("Q클로버", 10),
    CLOVER_JACK("J클로버", 10),
    CLOVER_ACE("A클로버", 11);

    private String name;
    private int score;
    private static final Random random = new Random();

    Card(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isAce() {
        return this == CLOVER_ACE || this == HEART_ACE || this == SPADE_ACE || this == DIAMOND_ACE;
    }

    public static Card random() {
        Card[] cards = Card.values();
        return cards[random.nextInt(cards.length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
