package black_jack;

import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;
import black_jack.constant.user.Dealer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DealerTest {

    @Test
    void 딜러는_카드를_뽑고_가진_카드의_숫자_총합을_계산할_수_있다() {
        //given
        Dealer dealer = new Dealer();
        final Card sevenHearts = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);

        //when
        dealer.drawCard(sevenHearts);

        //then
        assertThat(dealer.getTotalRank()).isEqualTo(7);
    }
}
