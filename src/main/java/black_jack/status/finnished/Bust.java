package black_jack.status.finnished;

public class Bust extends Finished {
    @Override
    double profit(double battingMoney) {
        return -battingMoney;
    }
}
