package black_jack.status.finnished;

import black_jack.status.PlayerState;

public abstract class Finished implements PlayerState {

    @Override
    public boolean isFinished() {
        return true;
    }

    abstract double profit(double battingMoney);
}
