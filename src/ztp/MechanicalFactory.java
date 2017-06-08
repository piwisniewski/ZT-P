package ztp;

public class MechanicalFactory {
    private static int totalDemand = 0;
    private int demand;

    public MechanicalFactory(int demand) {
        this.demand = demand;
        totalDemand += demand;
    }

    public int getDemand() {
        return demand;
    }

    public static int getTotalDemand() {
        return totalDemand;
    }
}
