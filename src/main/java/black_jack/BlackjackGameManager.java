package black_jack;

import black_jack.constant.user.Dealer;
import black_jack.constant.user.Player;
import black_jack.constant.user.Players;
import black_jack.utils.ResultStringUtils;

/**
 *  블랙잭 게임 관리자
 */
public class BlackjackGameManager {
    private Players players;
    private Dealer dealer;

    public BlackjackGameManager(Players players) {
        this.players = players;
        this.dealer = new Dealer();
    }

    public void firstDealing() {
        playersDrawTwice();
        dealerDrawTwice();
    }

    private void dealerDrawTwice() {
        dealer.drawCard(Card.getRandomCard());
        dealer.drawCard(Card.getRandomCard());
    }

    private void playersDrawTwice() {
        players.allPlayersDrawCard();
        players.allPlayersDrawCard();
    }

    public void getBettingFromPlayer(String playerName, Integer bettingMoney) {
        Player player = players.findByName(playerName);
        player.placeBet(bettingMoney);
    }

    public void giveOneCardToPlayer(String playerName) {
        Player player = players.findByName(playerName);
        player.drawCard(Card.getRandomCard());
    }

    public void giveOneCardToDealer() {
        dealer.drawCard(Card.getRandomCard());
    }

    public Integer getDealerTotalRank() {
        return dealer.getTotalRank();
    }

    public String getResultString() {
        return ResultStringUtils.getBlackJackPlayerResultString(dealer) + players.getPlayersResultString();
    }
}
