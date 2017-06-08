package ztp;

import java.util.ArrayList;
import java.util.Arrays;

public class Ztp {
    private static ArrayList<Foundry> foundries;
    private static ArrayList<MechanicalFactory> factories;
    private static int sum;
    private double[][] totalCost;
    private double[] conditions;
    private double[] results;

    public Ztp() {
        init();
        computeTotalCost();
        prepareData();
        printResults();
    }

    private void init() {
        foundries = new ArrayList<>();
        factories = new ArrayList<>();
        foundries.add(new Foundry(350, 1540, 20, new int[]{125, 150, 100, 200}));
        foundries.add(new Foundry(300, 1550, 10, new int[]{75, 125, 150, 175}));
        foundries.add(new Foundry(350, 1570, 10, new int[]{100, 75, 125, 50}));
        factories.add(new MechanicalFactory(200));
        factories.add(new MechanicalFactory(200));
        factories.add(new MechanicalFactory(200));
        factories.add(new MechanicalFactory(200));
        sum = foundries.size() * (factories.size() + 1);
    }

    private void computeTotalCost() {
        totalCost = new double[foundries.size()][factories.size() + 1];
        for (int i = 0; i < foundries.size(); i++) {
            for (int j = 0; j < factories.size(); j++) {
                totalCost[i][j] = foundries.get(i).getProductionCost() + foundries.get(i).getShipmentCost()[j];
            }
            totalCost[i][factories.size()] = foundries.get(i).getProductionCost() + foundries.get(i).getStorageCost();
        }
    }

    private void prepareData() {
        conditions = new double[foundries.size() * (factories.size() + 1)];
        Arrays.fill(conditions, 1);

        double[] suppliers = new double[foundries.size()];
        for (int i = 0; i < foundries.size(); i++) {
            suppliers[i] = foundries.get(i).getProductionCapability();
        }

        double[] receivers = new double[factories.size() + 1];
        for (int i = 0; i < factories.size(); i++) {
            receivers[i] = factories.get(i).getDemand();
        }
        receivers[factories.size()] = Foundry.getTotalProductionCapabilities() - MechanicalFactory.getTotalDemand();

        double[] totalCost2 = new double[sum];
        int counter = 0;
        for (int i = 0; i < foundries.size(); i++) {
            for (int j = 0; j < factories.size() + 1; j++) {
                totalCost2[counter++] = totalCost[i][j];
            }
        }
        results = LinearOptimization.computeSolution(totalCost2, conditions, suppliers, receivers);
    }

    private void printResults() {
        StringBuilder output = new StringBuilder("Wyniki:\n");
        int counter = 0;
        for (int i = 1; i <= foundries.size(); i++) {
            for (int j = 1; j <= factories.size() + 1; j++) {
                output.append("x").append(i).append(j);
                output.append(" = ").append(results[counter++]).append("\n");
            }
        }
    }

    public static ArrayList<Foundry> getFoundries() {
        return foundries;
    }

    public static ArrayList<MechanicalFactory> getFactories() {
        return factories;
    }

    public static int getSum() {
        return sum;
    }

    public static void main(String... args) {
        new Ztp();
    }
}