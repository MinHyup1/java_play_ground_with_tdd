package black_jack.constant.user;

import black_jack.Cards;

public class Player extends BlackJackPlayer{
    private String name;
    public Player() {
        this.cards = new Cards();
    }
    public Player(String name) {
        this.cards = new Cards();
        this.name = name;
    }
}
