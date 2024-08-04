package blackjack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CardDeck 단위테스트")
public class CardDeckTest {

    @DisplayName("CardDeck은 빈 상태로 생성된다.")
    @Test
    void card_deck_is_initialized_to_empty_state() {
        CardDeck cardDeck = new CardDeck();

        assertThatThrownBy(() -> cardDeck.countUpScore())
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("no cards");
    }

    @DisplayName("CardDeck은 카드 덱에 카드를 추가할 수 있다.")
    @Test
    void card_deck_can_add_card() {
        CardDeck cardDeck = new CardDeck();
        assertThat(cardDeck.addCard(new Card(CardPattern.CLOVER_ACE))).isTrue();
    }

    @DisplayName("CardDeck에는 카드를 중복하여 추가할 수 없다.")
    @Test
    void card_deck_has_unique_cards() {
        CardDeck cardDeck = new CardDeck();

        assertThat(cardDeck.addCard(new Card(CardPattern.CLOVER_ACE))).isTrue();
        assertThat(cardDeck.addCard(new Card(CardPattern.CLOVER_ACE))).isFalse();
    }

    @DisplayName("CardDeck은 카드 목록의 점수를 합산할 수 있다.")
    @Test
    void card_deck_count_up_total_score_of_its_own_cards() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.addCard(new Card(CardPattern.CLOVER_ACE)); // 11
        cardDeck.addCard(new Card(CardPattern.HEART_TWO)); // 2

        assertThat(cardDeck.countUpScore()).isEqualTo(13);
    }

    @DisplayName("CardDeck은 카드 목록이 비어있을 때 예외를 발생시킨다.")
    @Test
    void countUp_throws_exception_when_card_deck_has_no_cards() {
        CardDeck cardDeck = new CardDeck();

        assertThatThrownBy(() -> cardDeck.countUpScore())
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("no cards");
    }
}
