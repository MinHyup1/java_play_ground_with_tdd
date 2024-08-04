package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PlayerStatus 단위테스트")
public class PlayerStatusTest {

    @DisplayName("PlayerStatus는 Player를 입력하여 생성한다.")
    @Test
    void player_status_is_created_with_player_instance() {
        Player participant = Player.participant("참가자1", 10000, new CardDeck());
        PlayerStatus playerStatus = new PlayerStatus(participant);
        assertThat(playerStatus).isNotNull();
    }
}
