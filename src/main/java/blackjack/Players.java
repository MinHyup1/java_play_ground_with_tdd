package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PrintDTO> getPrintCards() {
        return players.stream()
            .map(player -> new PrintDTO(player, player.getCardPrint()))
            .collect(Collectors.toList());
    }

    public void dealOutCards() {
        for (Player player : players) {
            while (!player.addCard(Card.random())) {
            }
            while (!player.addCard(Card.random())) {
            }
        }
    }
}
