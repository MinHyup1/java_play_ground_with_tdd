package blackjack;

public class Card {

    private String pattern;
    private int score;

    public Card(String pattern, int score) {
        this.pattern = pattern;
        this.score = score;
    }

    public String getPattern() {
        return pattern;
    }

    public int getScore() {
        return score;
    }
}
