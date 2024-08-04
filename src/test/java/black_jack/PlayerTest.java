package black_jack;

import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;
import black_jack.constant.user.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

    @Test
    void 플레이어는_카드를_뽑고_가진_카드의_숫자_총합을_계산할_수_있다() {
        //given
        Player player = new Player("player");
        final Card sevenHearts = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);

        //when
        player.drawCard(sevenHearts);

        //then
        assertThat(player.getTotalRank()).isBetween(1, 13);
    }
}
