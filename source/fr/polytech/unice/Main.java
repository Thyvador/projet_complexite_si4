package fr.polytech.unice;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.fitting.AbstractFitting;
import fr.polytech.unice.utils.DataParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 3; i++) {
                runAlgo(args[0] + "exemple100.txt", i);
                runAlgo(args[0] + "exemple1000.txt", i);
                runAlgo(args[0] + "exemple500.txt", i);
                runAlgo(args[0] + "monexemple.txt", i);
            }
        } catch (IOException | OverLoadedBinException e) {
            e.printStackTrace();
        }
    }

    private static void runAlgo(String path, int i) throws OverLoadedBinException, IOException {
        AbstractFitting algo = DataParser.parseData(path, i);
        algo.fit();
        DataParser.writeResult(algo);
    }
}

