package black_jack.player.state;

import black_jack.Card;
import black_jack.Cards;
import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;
import black_jack.user.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

/*
* 처음 카드 2장을 뽑은 후 상태 테스트
* */
public class AfterOpeningDealTest {

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받은_후_카드의_합이_21이_넘지_않는다면_더받을_수_있다 () {
        // given
        final Player player = new Player("player1");
        final Card sevenHearts = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);
        final Card eightHearts = new Card(CardSuitType.HEARTS, CardRankType.EIGHT);
        final Cards cards = new Cards(sevenHearts,eightHearts);

        // when
        player.OpeningDeal(cards);
        boolean isCanDraw = player.isCanDraw();

        // then
        assertThat(isCanDraw).isEqualTo(true);
    }

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받은_후_카드의_합이_21이_넘는다면_카드를_더_받을_수_없다 () {
        // given
        final Player player = new Player("player1");
        final Card king = new Card(CardSuitType.HEARTS, CardRankType.KING);
        final Card eight = new Card(CardSuitType.HEARTS, CardRankType.EIGHT);
        final Cards cards = new Cards(king,eight);

        // when
        player.OpeningDeal(cards);
        boolean isCanDraw = player.isCanDraw();

        // then
        assertThat(isCanDraw).isEqualTo(false);
    }

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받은_후_카드의_합이_21이_넘지않는다면_카드받는것을_멈출_수_있다 () {
        // given
        final Player player = new Player("player1");
        final Card seven = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);
        final Card eight = new Card(CardSuitType.HEARTS, CardRankType.EIGHT);
        final Cards cards = new Cards(seven,eight);

        player.OpeningDeal(cards);

        // when
        player.stay();

        // then
        assertThat(player.isFinished()).isEqualTo(true);
    }

    @Test
    void 플레이어는_게임시작시_2장의_카드를_받은_후_카드의_합이_21보다_같거나_크다면_카드받는것을_멈출_수_없다 () {
        // given
        final Player player = new Player("player1");
        final Card king = new Card(CardSuitType.HEARTS, CardRankType.KING);
        final Card eight = new Card(CardSuitType.HEARTS, CardRankType.EIGHT);
        final Cards cards = new Cards(king,eight);

        player.OpeningDeal(cards);

        // when, then
        assertThatThrownBy(player::stay).isInstanceOf(IllegalArgumentException.class);
    }
}
