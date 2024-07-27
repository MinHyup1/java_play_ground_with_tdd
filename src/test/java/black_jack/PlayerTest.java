package black_jack;

import black_jack.constant.user.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

    @Test
    void 플레이어는_카드를_뽑고_가진_카드의_숫자_총합을_계산할_수_있다() {
        //given
        Player player = new Player();

        //when
        player.drawCard();

        //then
        assertThat(player.getTotalRank()).isBetween(1, 13);
    }
}
