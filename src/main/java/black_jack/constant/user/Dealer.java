package black_jack.constant.user;

import black_jack.Cards;

public class Dealer extends BlackJackPlayer{
    private static final String DEALER_NAME = "딜러";
    public Dealer() {
        this.cards = new Cards();
        super.name = DEALER_NAME;
    }
}
