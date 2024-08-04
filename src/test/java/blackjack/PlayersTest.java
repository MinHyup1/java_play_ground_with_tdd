package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Players 단위테스트")
public class PlayersTest {

    @DisplayName("Players는 Player 목록을 입력하여 생성한다.")
    @Test
    void players_created_with_player_statuses() {
        Player 참가자1 = Player.participant("참가자1", 10000, new CardDeck(), true);
        Player 참가자2 = Player.participant("참가자2", 20000, new CardDeck(), true);
        Player 참가자3 = Player.participant("참가자3", 30000, new CardDeck(), true);
        Players players = new Players(List.of(참가자1, 참가자2, 참가자3));

        assertThat(players).isNotNull();
    }

    @DisplayName("플레이어 한 명이라도 추가 뽑기 여부가 true인 경우 isDone()은 false를 리턴한다.")
    @Test
    void players_isDone_return_false_when_even_just_one_players_proceeding_is_true() {
        Player 참가자1 = Player.participant("참가자1", 10000, new CardDeck(), true);
        Player 참가자2 = Player.participant("참가자2", 20000, new CardDeck(), false);
        Players players = new Players(List.of(참가자1, 참가자2));

        assertThat(players.isAllDone()).isFalse();
    }

    @DisplayName("모든 플레이어의 추가 뽑기 여부가 false인 경우 isDone()은 true를 리턴한다.")
    @Test
    void players_isDone_return_true_when_all_players_proceeding_is_false() {
        Player 참가자1 = Player.participant("참가자1", 10000, new CardDeck(), false);
        Player 참가자2 = Player.participant("참가자2", 20000, new CardDeck(), false);
        Players players = new Players(List.of(참가자1, 참가자2));

        assertThat(players.isAllDone()).isFalse();
    }
}
