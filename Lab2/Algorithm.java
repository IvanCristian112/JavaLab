import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class Algorithm {
    protected Problem problem;
    public Algorithm(Problem problem) {
        this.problem = problem;


    }
    public abstract Solution solve();


}
