package blackjack;

public class PlayerStatus {

    private final Player player;
    private final boolean proceeding;

    public PlayerStatus(Player player, boolean proceeding) {
        this.player = player;
        this.proceeding = proceeding;
    }

    public boolean isProceeding() {
        return proceeding;
    }
}
