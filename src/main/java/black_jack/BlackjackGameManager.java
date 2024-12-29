package black_jack;

import black_jack.user.Dealer;
import black_jack.user.Player;
import black_jack.user.Players;
import black_jack.utils.ResultStringUtils;

/**
 *  블랙잭 게임 관리자
 */
public class BlackjackGameManager {
    private Players players;
    private Dealer dealer;


    public BlackjackGameManager(Dealer dealer, Players players) {
        this.players = players;
        this.dealer = dealer;
    }

    public void firstDealing() {
        playersDrawTwice();
    }

    private void playersDrawTwice() {
    }

    public void getBettingFromPlayer(String playerName, Integer bettingMoney) {
        Player player = players.findByName(playerName);
        player.placeBet(bettingMoney);
    }

    public void giveOneCardToPlayer(String playerName) {
        Player player = players.findByName(playerName);
    }


    public Integer getDealerTotalRank() {
        return dealer.getTotalRank();
    }

    public String getResultString() {
        return ResultStringUtils.getBlackJackPlayerResultString(dealer) + players.getPlayersResultString();
    }
}
