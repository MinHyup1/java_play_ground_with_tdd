package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    Players(List<Player> players) {
        this.players = new ArrayList<>(players);
        addDealerStatus();
    }
    //todo 딜러를 구분하고 싶은데..
    private void addDealerStatus() {
        Player dealer = Player.dealer(new CardDeck(), true);
        this.players.add(dealer);
    }

    public boolean isAllDone() {
        return !players.stream()
            .anyMatch(Player::isProceeding);
    }
}
