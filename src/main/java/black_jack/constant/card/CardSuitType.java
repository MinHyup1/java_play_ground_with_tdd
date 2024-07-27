package black_jack.constant.card;

public enum CardSuitType {
    SPADES("스페이드"),
    HEARTS("하트"),
    DIAMONDS("다이아몬드"),
    CLUBS("클로버");

    private String name;

    CardSuitType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
