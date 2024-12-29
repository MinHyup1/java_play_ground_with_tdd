package black_jack.status.running;

import black_jack.Card;
import black_jack.status.finnished.Stay;
import black_jack.user.Player;
import black_jack.status.PlayerState;
import black_jack.status.finnished.Blackjack;


/*
* 처음 2장의 카드를 뽑은 상태
 */
public class AfterOpeningDeal extends Running {

    @Override
    public PlayerState draw(Player player, Card card) {
        if(player.getTotalRank() > 21) return new AfterOpeningDeal();
        if(player.getTotalRank() == 21) return new Blackjack();
        return null;
    }

    @Override
    public PlayerState stay(Player player) {
        return new Stay();
    }
}
