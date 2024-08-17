package black_jack.user;

import black_jack.Card;
import black_jack.utils.ResultStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players = new ArrayList<Player>();
    public Players(Player... players) {
        this.players = Arrays.asList(players);
    }


    public Player findByName(String playerName) {
        for (Player player : this.players) {
            if(player.isEqualName(playerName)) return player;
        }
        throw new RuntimeException(playerName + "is not exist");
    }

    public String getPlayersResultString() {
        return players.stream().map(ResultStringUtils::getBlackJackPlayerResultString).collect(Collectors.joining());
    }
}
