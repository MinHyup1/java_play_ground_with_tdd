package blackjack;

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
}
