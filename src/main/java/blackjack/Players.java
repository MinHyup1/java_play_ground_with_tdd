package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final Integer BLACKJACK_POINT = 21;

    private final List<Player> players;
    private final Player dealer;

    Players(List<Player> players, Player dealer) {
        this.players = new ArrayList<>(players);
        this.dealer = dealer;
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

    public boolean anyoneGotBlackjack() {
        return players.stream()
            .anyMatch(player -> player.totalCardPoint() == BLACKJACK_POINT);
    }

    public void checkDraw() {
        boolean blackjackPlayerExists = players.stream()
            .anyMatch(Player::gotBlackjack);

        if (blackjackPlayerExists && dealer.gotBlackjack()) {
            players.forEach(Player::draw);
        }
    }
}
