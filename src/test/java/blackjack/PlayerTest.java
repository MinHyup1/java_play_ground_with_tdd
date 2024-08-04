package blackjack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player 단위테스트")
public class PlayerTest {

    @DisplayName("참가자는 이름, 베팅 금액, 카드 덱, 추가 카드 뽑기 여부를 입력받아 생성한다.")
    @Test
    void participants_have_name_and_bet_amount() {
        Player participant = Player.participant("이름", 10000, new CardDeck(), true);
        assertThat(participant.getName()).isEqualTo("이름");
        assertThat(participant.getBetAmount()).isEqualTo(10000);
    }

    @DisplayName("참가자 이름에 null 입력 불가")
    @Test
    void participants_can_not_have_null_name() {
        Assertions.assertThatThrownBy(() -> Player.participant(null, 10000, new CardDeck(), true))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("name");
    }

    @DisplayName("참가자 배팅 금액에 0 이하의 값 입력 불가")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void participants_can_not_have_lte_zero_betAmount(int invalidBetAmount) {
        Assertions.assertThatThrownBy(() -> Player.participant("이름", invalidBetAmount, new CardDeck(), true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("betAmount");
    }

    @DisplayName("딜러는 베팅 금액을 가지지 않는다.")
    @Test
    void dealer_has_name_only() {
        Player dealer = Player.dealer(new CardDeck(), true);
        assertThat(dealer.getName()).isEqualTo("딜러");
        assertThat(dealer.getBetAmount()).isNull();
    }

    @DisplayName("플레이어는 카드 덱에 카드를 추가할 수 있다.")
    @Test
    void player_can_add_card_to_his_own_card_deck() {
        Player participant = Player.participant("참가자1", 10000, new CardDeck(), true);
        Player dealer = Player.dealer(new CardDeck(), true);

        assertThat(participant.addCard(Card.CLOVER_ACE)).isTrue();
        assertThat(dealer.addCard(Card.CLOVER_ACE)).isTrue();
    }

    @DisplayName("플레이어는 카드 덱에 카드를 중복하여 추가할 수 있다.")
    @Test
    void player_has_unique_cards() {
        Player participant = Player.participant("참가자1", 10000, new CardDeck(), true);
        Player dealer = Player.dealer(new CardDeck(), true);

        assertThat(participant.addCard(Card.CLOVER_ACE)).isTrue();
        assertThat(participant.addCard(Card.CLOVER_ACE)).isFalse();
        assertThat(dealer.addCard(Card.CLOVER_ACE)).isTrue();
        assertThat(dealer.addCard(Card.CLOVER_ACE)).isFalse();
    }

    @DisplayName("addCard에 null을 입력하면 예외를 발생시킨다.")
    @Test
    void player_add_card_exception_test() {
        Player participant = Player.participant("참가자1", 10000, new CardDeck(), true);

        assertThatThrownBy(() -> participant.addCard(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("card");
    }
}
