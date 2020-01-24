package io.chessgame.engine;

import java.util.List;

public class Helpers {

    public static double computeAverageRuntime(List<Double> l) {
        return l.stream()
                .mapToDouble(x -> x)
                .average()
                .getAsDouble();
    }

    public static double computeBestRuntime(List<Double> l) {
        return l.stream()
                .mapToDouble(x -> x)
                .min()
                .getAsDouble();
    }

    public static Runner findFastestRunner(List<Runner> l) {
        Runner r = l.get(0);
        double runtime = l.get(0).getBestRuntime();
        for (int i = 1; i < l.size(); i++) {
            double bestRuntime = l.get(i).getBestRuntime();
            if (runtime > bestRuntime) {
                runtime = bestRuntime;
                r = l.get(i);
            }
        }
        return r;


    }

}
