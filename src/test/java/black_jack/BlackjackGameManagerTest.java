package black_jack;

import black_jack.constant.user.Player;
import black_jack.constant.user.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BlackjackGameManagerTest {
    @Test
    void 블랙잭_객체는_딜러와_플레이어들에게_시작시_카드를_2장씩_나누어줘야_한다() {
        //given
        Player player1 = new Player();
        Player player2 = new Player();

        BlackjackGameManager gameManager = new BlackjackGameManager(new Players(player1, player2));
        gameManager.dealing();

        assertThat(player1.getTotalRank()).isBetween(2, 26);
        assertThat(player2.getTotalRank()).isBetween(2, 26);
    }
}
