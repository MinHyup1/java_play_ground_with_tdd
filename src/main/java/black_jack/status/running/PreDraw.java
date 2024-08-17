package black_jack.status.running;

import black_jack.Cards;
import black_jack.user.Player;
import black_jack.status.PlayerState;
import black_jack.status.finnished.Blackjack;
import black_jack.status.finnished.Bust;


/*
* 게임시작 후 어떠한 카드도 받지 않은 상태
* */
public class PreDraw extends Running {

    @Override
    public PlayerState draws(Player player, Cards cards) {
        player.addCards(cards);

        if(player.getTotalRank() > 21) return new Bust();
        if(player.getTotalRank() < 21) return new AfterOpeningDeal();
        if(player.getTotalRank() == 21) return new Blackjack();

        throw new IllegalArgumentException();
    }

    @Override
    public boolean isPreDraw() {
        return true;
    }
}
