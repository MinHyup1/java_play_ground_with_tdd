package black_jack;

import black_jack.constant.user.Dealer;
import black_jack.constant.user.Players;

public class BlackjackGameManager {
    private Players players;
    private Dealer dealer;
    public BlackjackGameManager(Players players) {
        this.players = players;
        this.dealer = new Dealer();
    }

    public void dealing() {
        playersDrawTwice();
        dealerDrawTwice();
    }

    private void dealerDrawTwice() {
        dealer.drawCard();
        dealer.drawCard();
    }

    private void playersDrawTwice() {
        players.allPlayersDrawCard();
        players.allPlayersDrawCard();
    }
}
