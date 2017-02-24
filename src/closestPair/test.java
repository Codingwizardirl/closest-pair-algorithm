package closestPair;

import java.util.Arrays;

/**
 * Created by Pavel on 24/02/2017.
 */
public class test {
    public static void main(String[] argv) {
            /* CONTENT OF THE TEST SCRIPT */
//             ClosestPairToolkit.getRuntimes(10, 250, "closestPairTimes");
//            double[] ratios = ClosestPairToolkit.getRatios(10, 250, 175, "test");
//            ClosestPairToolkit.plotRuntimes(ratios[0], ratios[1],"closestPairTimes");
        try {
            ClosestPairToolkit.closestPairCheck(100, 2500);
        } catch (InvalidNumberOfTestsException e) {
            e.printStackTrace();
        } catch (UnwritablePointSetException e) {
            e.printStackTrace();
        }
    }
}
