package blackjack;

import lombok.Getter;

@Getter
public class PrintDTO {

    private final Player player;
    private String cardPrint;

    public PrintDTO(Player player, String cardPrint) {
        this.player = player;
        this.cardPrint = cardPrint;
    }
}
