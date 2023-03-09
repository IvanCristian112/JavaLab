import java.util.ArrayList;

public class Solution {
    boolean isReachable;
    private ArrayList<Location> route;

    public Solution() {
        route = new ArrayList<Location>();
    }

    @Override
    public String toString() {
        return "Solution{" +
                "isReachable=" + isReachable +
                ", route=" + route +
                '}';
    }
}
