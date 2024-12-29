package black_jack;

import black_jack.constant.card.CardRankType;
import black_jack.constant.card.CardSuitType;
import black_jack.user.Dealer;
import black_jack.user.Player;
import black_jack.user.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BlackjackGameManagerTest {
//    @Test
//    void 블랙잭관리자_객체는_딜러와_플레이어들에게_시작시_카드를_2장씩_나누어줘야_한다() {
//        //given
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(),new Players(player1, player2));
//
//        //when
//        gameManager.firstDealing();
//
//        //then
//        assertThat(player1.getTotalRank()).isBetween(2, 26);
//        assertThat(player2.getTotalRank()).isBetween(2, 26);
//    }
//
//    @Test
//    void 블랙젝관리자_객체는_플레이어의_배팅을_도와준다() {
//        //given
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(), new Players(player1, player2));
//        Integer bettingMoney = 10000;
//
//        //when
//        gameManager.getBettingFromPlayer("player1",bettingMoney);
//
//        //then
//        assertThat(player1.getBattingMoney()).isEqualTo(bettingMoney);
//    }
//
//    @Test
//    void 블랙젝관리자_객체는_플레이어에게_한장의_카드를_더_줄_수_있다() {
//        //given
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(), new Players(player1, player2));
//
//        //when
//        gameManager.giveOneCardToPlayer("player1");
//        gameManager.giveOneCardToPlayer("player2");
//
//        //then
//        assertThat(player1.getTotalRank()).isBetween(1, 13);
//        assertThat(player2.getTotalRank()).isBetween(1, 13);
//    }
//
//    @Test
//    void 블랙젝관리자_객체는_딜러에게_한장의_카드를_더_줄_수_있다() {
//        //given
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(), new Players(player1, player2));
//
//        //when
//        gameManager.giveOneCardToDealer();
//
//        //then
//        assertThat(gameManager.getDealerTotalRank()).isBetween(1, 13);
//    }
//
//    @Test
//    void 블랙젝관리자_객체는_게임을종료해_게임결과를_반환할_수_있다() {
//        //given
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(), new Players(player1, player2));
//
//        //when
//        gameManager.firstDealing();
//
//
//        //then
//        System.out.println(gameManager.getResultString());
//    }
//
//    @Test
//    void 블랙젝관리자_객체는_게임을종료해_최종_수익을_계산할_수_있다() {
//        //given
//        Player player1 = new Player("player1");
//        final Card sevenHearts = new Card(CardSuitType.HEARTS, CardRankType.SEVEN);
//        player1.drawCard(sevenHearts);
//
//        BlackjackGameManager gameManager = new BlackjackGameManager(new Dealer(),new Players(player1));
//
//        //when
//        gameManager.firstDealing();
//
//        //then
//        System.out.println(gameManager.getResultString());
//    }
}
