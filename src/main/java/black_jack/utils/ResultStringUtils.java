package black_jack.utils;

import black_jack.constant.user.BlackJackPlayer;

public class ResultStringUtils {
    public static String getBlackJackPlayerResultString(BlackJackPlayer player) {
        return player.getName() + "카드 : " + player.getCardsToString() + " - 걸과 : " + player.getTotalRank() + "\n";
    }
}
