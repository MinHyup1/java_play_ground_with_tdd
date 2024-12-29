package black_jack.status.finnished;

public class Blackjack extends Finished {
    @Override
    double profit(double battingMoney) {
        return battingMoney * 1.5;
    }
}
