package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<PlayerStatus> playerStatuses;

    Players(List<PlayerStatus> playerStatuses) {
        this.playerStatuses = new ArrayList<>(playerStatuses);
        addDealerStatus();
    }
    //todo 딜러를 구분하고 싶은데..
    private void addDealerStatus() {
        Player dealer = Player.dealer(new CardDeck());
        PlayerStatus dealerStatus = new PlayerStatus(dealer, true);
        this.playerStatuses.add(dealerStatus);
    }

    public boolean isAllDone() {
        return !playerStatuses.stream()
            .anyMatch(PlayerStatus::isProceeding);
    }
}
