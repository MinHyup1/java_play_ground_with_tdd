package black_jack.player.state;

import black_jack.Card;
import black_jack.Cards;
import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;
import black_jack.user.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
* 게임 시작 후 카드를 뽑기전 상태 테스트
* */
public class PreDrawTest {

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받을_수_있는_상태인지_확인_가능하다 () {
        // given
        final Player player = new Player("player1");

        // when
        boolean isPreDraw = player.isPreDraw();

        // then
        assertThat(isPreDraw).isEqualTo(true);
    }

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받을_수_있다 () {
        // given
        final Player player = new Player("player1");
        final Card sevenHearts = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);
        final Card eightHearts = new Card(CardSuitType.HEARTS, CardRankType.EIGHT);
        final Cards cards = new Cards(sevenHearts,eightHearts);

        // when
        player.OpeningDeal(cards);

        // then
        assertThat(player.getTotalRank()).isEqualTo(15);
    }
}
