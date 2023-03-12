import java.util.ArrayList;

public class Solution {
    private boolean isReachable;
    private ArrayList<Location> route;

    public Solution() {
        route = new ArrayList<>();
    }

    public void setRoute(ArrayList<Location> route) {
        this.route = route;
    }

    public ArrayList<Location> getRoute() {
        return route;
    }

    public void setReachable(boolean reachable) {
        isReachable = reachable;
    }

    public boolean getReachable() {
        return isReachable;
    }

    @Override
    public String toString() {
        if (!route.isEmpty()) return "isReachable: " + isReachable +  " Route: " + route;
        else return "isReachable: " + isReachable;
    }
}
