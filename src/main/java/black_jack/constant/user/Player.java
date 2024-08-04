package black_jack.constant.user;

import black_jack.Cards;

public class Player extends BlackJackPlayer{
    private Integer battingMoney; // 배팅금액
    public Player(String name) {
        this.cards = new Cards();
        super.name = name;
    }

    public Integer getBattingMoney() {
        return battingMoney;
    }

    public boolean isEqualName(String nameParam) {
        return this.name.equals(nameParam);
    }

    public void placeBet(Integer bettingMoney) {
        this.battingMoney = bettingMoney;
    }
}
