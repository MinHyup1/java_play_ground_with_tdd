package blackjack;

import java.util.List;

public class Print {

    public static void current(List<PrintDTO> prints) {
        for (PrintDTO print : prints) {
            System.out.print(print.getPlayer().getName() + " 카드: " + print.getCardPrint() + "\n");
        }
    }
}
