package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Card 단위테스트")
public class CardTest {

    @DisplayName("Card는 카드 무늬와 점수를 가지고 있는 CardPattern을 주입받아 생성한다.")
    @Test
    void test() {
        Card card = new Card(CardPattern.CLOVER_EIGHT);
        assertThat(card).isNotNull();
    }
}
