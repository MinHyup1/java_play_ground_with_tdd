package black_jack.status;

import black_jack.Card;
import black_jack.Cards;
import black_jack.user.Player;

public interface PlayerState {
    boolean isFinished();

    default boolean isPreDraw() {
        return false;
    }

    default PlayerState draw(Player player, Card card) {
        throw new IllegalArgumentException("Player State is not Running");
    }

    default PlayerState draws(Player player, Cards cards) {
        throw new IllegalArgumentException("Player State is not Start");
    }

    default PlayerState stay(Player player) {
        throw new IllegalArgumentException("Player State can not stay");
    }
}
