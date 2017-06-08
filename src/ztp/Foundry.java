package ztp;

public class Foundry {
    private static int totalProductionCapabilities = 0;
    private int productionCapability;
    private int productionCost;
    private int storageCost;
    private int[] shipmentCost;

    public Foundry(int productionCapability, int productionCost, int storageCost, int[] shipmentCost) {
        this.productionCapability = productionCapability;
        totalProductionCapabilities += productionCapability;
        this.productionCost = productionCost;
        this.storageCost = storageCost;
        this.shipmentCost = shipmentCost;
    }

    public int getProductionCapability() {
        return productionCapability;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public int getStorageCost() {
        return storageCost;
    }

    public int[] getShipmentCost() {
        return shipmentCost;
    }

    public static int getTotalProductionCapabilities() {
        return totalProductionCapabilities;
    }
}