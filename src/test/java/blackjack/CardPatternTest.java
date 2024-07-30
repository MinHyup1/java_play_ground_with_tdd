package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CardPattern 단위테스트")
public class CardPatternTest {

    @DisplayName("CardPattern은 카드 무늬와 점수 정보를 가진다.")
    @Test
    void name() {
        CardPattern spadeTwo = CardPattern.SPADE_TWO;
        Assertions.assertThat(spadeTwo.name).isEqualTo("스페이드");
        Assertions.assertThat(spadeTwo.score).isEqualTo(2);
    }
}
