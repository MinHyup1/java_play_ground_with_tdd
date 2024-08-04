package blackjack;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Players 단위테스트")
public class PlayersTest {

    @DisplayName("Players는 PlayerStatus 목록을 입력하여 생성한다.")
    @Test
    void players_created_with_player_statuses() {
        Player 참가자1 = Player.participant("참가자1", 10000, new CardDeck());
        Player 참가자2 = Player.participant("참가자2", 20000, new CardDeck());
        Player 참가자3 = Player.participant("참가자3", 30000, new CardDeck());
        Players players = new Players(List.of(
            new PlayerStatus(참가자1),
            new PlayerStatus(참가자2),
            new PlayerStatus(참가자3)));

        Assertions.assertThat(players).isNotNull();
    }
}
