package black_jack.user;

import black_jack.Card;
import black_jack.Cards;
import black_jack.status.PlayerState;
import black_jack.status.running.PreDraw;

public class Player extends BlackJackPlayer{
    private Integer battingMoney; // 배팅금액
    private PlayerState state; // 플레이어 상태
    public Player(String name) {
        this.cards = new Cards();
        this.state = new PreDraw();
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

    public void draw(Card card) {
        this.state = state.draw(this,card);
    }

    public void OpeningDeal(Cards cards) {
        if(cards.size() != 2 ){
            throw new IllegalArgumentException("hit is draw only two cards");
        }
        this.state = state.draws(this, cards);
    }

    public void addCards(Cards cards) {
        this.cards.addCards(cards);
    }

    public boolean isPreDraw() {
        return this.state.isPreDraw();
    }

    public boolean isCanDraw() {
        return this.getTotalRank() < 21 && !this.state.isFinished();
    }

    public void stay() {
        this.state = this.state.stay(this);
    }

    public boolean isFinished() {
        return this.state.isFinished();
    }
}
