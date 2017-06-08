package ztp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;

public class LinearOptimization {

    public static double[] computeSolution(double[] totalCost, double[] conditions, double[] suppliers, double[] receivers) {
        LinearObjectiveFunction f = new LinearObjectiveFunction(totalCost, 0);

        Collection constraints = new ArrayList();
        double[] temp;
        int counter = 0;
        for (int i = 0; i <= Ztp.getSum()- Ztp.getFactories().size()+1; i+= Ztp.getFactories().size()+1) {
            temp = new double[Ztp.getSum()];
            Arrays.fill(temp, i, i+Ztp.getFactories().size()+1, 1);
            //System.arraycopy(conditions, 0, temp, 0, Ztp.getFactories().size() + 1);
            constraints.add(new LinearConstraint(temp, Relationship.EQ, suppliers[counter++]));
        }

        counter = 0;
        for (int i = 0; i < Ztp.getFactories().size() + 1; i++) {
            temp = new double[Ztp.getSum()];
            for (int j = 0; j < Ztp.getSum(); j+=Ztp.getFactories().size() + 1) {
                temp[i+j] = 1;
            }
            constraints.add(new LinearConstraint(temp, Relationship.EQ, receivers[counter++]));
        }

        RealPointValuePair solution = null;
        try {
            solution = new SimplexSolver().optimize(f, constraints, GoalType.MINIMIZE, true);
        } catch (OptimizationException e) {
            System.out.println("LOL");
        }
        double[] results = new double[Ztp.getSum()];
        if (solution != null) {
            for (int i = 0; i < Ztp.getSum(); i++) {
                results[i] = solution.getPoint()[i];
            }
        }
        return results;
    }
}