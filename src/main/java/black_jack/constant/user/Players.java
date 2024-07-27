package black_jack.constant.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<Player>();
    public Players(Player... players) {
        this.players = Arrays.asList(players);
    }

    public void allPlayersDrawCard() {
        players.forEach(Player::drawCard);
    }
}
