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
        assertThat(cardDeck.addCard(Card.CLOVER_ACE)).isTrue();
    }

    @DisplayName("CardDeck에는 카드를 중복하여 추가할 수 없다.")
    @Test
    void card_deck_has_unique_cards() {
        CardDeck cardDeck = new CardDeck();

        assertThat(cardDeck.addCard(Card.CLOVER_ACE)).isTrue();
        assertThat(cardDeck.addCard(Card.CLOVER_ACE)).isFalse();
    }

    @DisplayName("CardDeck은 카드 목록의 점수를 합산할 수 있다.")
    @Test
    void card_deck_count_up_total_score_of_its_own_cards() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.addCard(Card.CLOVER_ACE); // 11
        cardDeck.addCard(Card.HEART_TWO); // 2

        assertThat(cardDeck.countUpScore()).isEqualTo(13);
    }

    @DisplayName("CardDeck은 합산 점수가 21점을 초과하면 Ace를 1점으로 계산한다.")
    @Test
    void card_deck_count_ace_as_one_point_when_total_score_is_over_21() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.addCard(Card.CLOVER_ACE); // 11 -> 1
        cardDeck.addCard(Card.HEART_TWO); // 2
        cardDeck.addCard(Card.CLOVER_JACK); // 10

        int score = cardDeck.countUpScore();

        assertThat(score).isEqualTo(13);
    }

    @DisplayName("addCard()에 null을 입력하면 예외를 발생시킨다.")
    @Test
    void card_deck_add_card_exception_test() {
        CardDeck cardDeck = new CardDeck();

        assertThatThrownBy(() -> cardDeck.addCard(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("card");
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
