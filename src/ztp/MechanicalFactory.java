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

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public static int getTotalDemand() {
        return totalDemand;
    }

    public static void setTotalDemand(int totalDemand) {
        MechanicalFactory.totalDemand = totalDemand;
    }
}
