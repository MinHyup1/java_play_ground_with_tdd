package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cards 단위테스트")
public class CardsTest {

    @DisplayName("Cards는 Card 컬렉션에 Card를 추가할 수 있다.")
    @Test
    void cards_add_test() {
        Cards cards = new Cards();
        cards.add(new Card(CardPattern.CLOVER_ACE));
    }

    @DisplayName("Cards는 Card 컬렉션의 점수를 합산할 수 있다.")
    @Test
    void cards_add_up_test() {
        Cards cards = new Cards();
        cards.add(new Card(CardPattern.CLOVER_ACE));
        cards.add(new Card(CardPattern.HEART_EIGHT));
        int score = cards.addUp();

        Assertions.assertThat(score).isEqualTo(19);
    }

    @DisplayName("Card 컬렉션의 합산 점수가 21점을 초과하면 Ace를 1점으로 계산한다.")
    @Test
    void cards_score_ace_as_one_point_when_total_score_is_over_21() {
        Cards cards = new Cards();
        cards.add(new Card(CardPattern.CLOVER_ACE));
        cards.add(new Card(CardPattern.SPADE_FOUR));
        cards.add(new Card(CardPattern.HEART_EIGHT));
        int score = cards.addUp();

        Assertions.assertThat(score).isEqualTo(13);
    }
}
