package blackjack;

import java.util.List;
import java.util.Map;

public class Blackjack {

    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)\njh,mh\n");
        System.out.println("jh의 배팅 금액은?\n10000\n");
        System.out.println("mh의 배팅 금액은?\n20000\n");
        System.out.println("딜러와 jh, mh에게 카드를 2장씩 나누었습니다.");

        Players players = new Players(List.of(
            Player.participant("jh", 10000, new CardDeck(), true),
            Player.participant("mh", 20000, new CardDeck(), true)));

        players.dealOutCards();
//        while (!players.isAllDone()) {
            List<PrintDTO> printCards = players.getPrintCards();
            Print.current(printCards);

//        }
    }
}
