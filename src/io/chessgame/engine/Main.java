package io.chessgame.engine;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String SEAS = "Seas";

    public static void main(String[] args) {
        final float MAX_UPPER_BOUND = 500.0f;
        List<Runner> runners = new ArrayList<>();
        Path path = Path.of("C:\\Users\\Adrian\\Desktop\\HTL_POS_JAVA_Übungen\\läufer\\src\\invalid.txt");
        int count = 0;
        try (Scanner scanner = new Scanner(path);){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                try {
                    String name = parts[0];
                    Validator.checkNotNullOrEmpty(name);
                    Runner r = new Runner(name);
                    for (int i = 1; i < parts.length; i++) {
                        double runtime = Double.parseDouble(parts[i].replace(",", "."));
                        try {
                            Validator.checkPositive((float) runtime);
                            try {
                                Validator.checkNotGreaterThan((float) runtime, MAX_UPPER_BOUND);
                                r.addRuntime(runtime);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Ignoring runner because of input data (Value must must not exceed the upper bound) " + MAX_UPPER_BOUND);
                                continue;
                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println("Ignoring runner because of input data (Value must be positive)");
                            continue;
                        }

                    }
                    runners.add(r);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ignoring runner because of input data (Value must not be null or empty!)");
                    continue;
                }
            }
            for (Runner runner : runners) {
                System.out.println(runner.toString());
            }


            System.out.println("\nFastest runner : \n" + Helpers.findFastestRunner(runners).toString());

        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Eingabedatei \n" +
                    "non_existing_file.txt  (Das System kann die angegebene Datei nicht finden)");
        }


        


    }

}
