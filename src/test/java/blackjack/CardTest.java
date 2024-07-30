package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Card 단위테스트")
public class CardTest {

    @DisplayName("Card는 모양과 점수를 가진다.")
    @Test
    void test() {
        Card card = new Card("스페이드", 2);
        assertThat(card.getPattern()).isEqualTo("스페이드");
        assertThat(card.getScore()).isEqualTo(2);
    }
}
