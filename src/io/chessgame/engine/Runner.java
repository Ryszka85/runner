package io.chessgame.engine;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private String name;
    private List<Double> laufzeiten;

    public Runner(String name) {
        this.name = name;
        laufzeiten = new ArrayList<>();
    }

    public double getAverageRuntime() {
        return Helpers.computeAverageRuntime(this.laufzeiten);
    }

    public double getBestRuntime() {
        return Helpers.computeBestRuntime(this.laufzeiten);
    }

    public void addRuntime(double time) {
        laufzeiten.add(time);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "             " +
                getBestRuntime() + " " +
                String.format("%.2f", getAverageRuntime());
    }
}
