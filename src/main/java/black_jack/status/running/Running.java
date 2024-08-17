package black_jack.status.running;
import black_jack.status.PlayerState;

public abstract class Running implements PlayerState {

    @Override
    public boolean isFinished() {
        return false;
    }
}
