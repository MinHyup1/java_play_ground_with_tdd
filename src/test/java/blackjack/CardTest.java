package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CardPattern 단위테스트")
public class CardTest {

    @DisplayName("CardPattern은 카드 무늬와 점수 정보를 가진다.")
    @Test
    void name() {
        Card spadeTwo = Card.SPADE_TWO;
        Assertions.assertThat(spadeTwo.getName()).isEqualTo("스페이드");
        Assertions.assertThat(spadeTwo.getScore()).isEqualTo(2);
    }
}
