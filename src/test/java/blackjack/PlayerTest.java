package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player 단위테스트")
public class PlayerTest {

    @DisplayName("참가자는 이름, 베팅 금액, 카드 덱을 입력받아 생성한다.")
    @Test
    void participants_have_name_and_bet_amount() {
        Player participant = Player.participant("이름", 10000, new CardDeck());
        assertThat(participant.getName()).isEqualTo("이름");
        assertThat(participant.getBetAmount()).isEqualTo(10000);
    }

    @DisplayName("참가자 이름에 null 입력 불가")
    @Test
    void participants_can_not_have_null_name() {
        Assertions.assertThatThrownBy(() -> Player.participant(null, 10000, new CardDeck()))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("name");
    }

    @DisplayName("참가자 배팅 금액에 0 이하의 값 입력 불가")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void participants_can_not_have_lte_zero_betAmount(int invalidBetAmount) {
        Assertions.assertThatThrownBy(() -> Player.participant("이름", invalidBetAmount, new CardDeck()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("betAmount");
    }

    @DisplayName("딜러는 베팅 금액을 가지지 않는다.")
    @Test
    void dealer_has_name_only() {
        Player dealer = Player.dealer(new CardDeck());
        assertThat(dealer.getName()).isEqualTo("딜러");
        assertThat(dealer.getBetAmount()).isNull();
    }
}
