package fr.polytech.unice;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.fitting.*;
import fr.polytech.unice.utils.DataParser;
import fr.polytech.unice.utils.Item;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainCSVStat {

    private static final int DEFAULT_BIN_SIZE = 100;


    public static void main(String[] args) throws OverLoadedBinException, IOException {

        FileWriter fileWriter = new FileWriter("stats.csv");

        writeCSVHeader(fileWriter);
        for (int i = 1; i <= 5; i++) {
            List<Item> items = generateRandomList(Math.pow(10, i));

            System.out.println(i + "\n");
            for (int j = 0; j <= 4; j++) {
                AbstractFitting algo = initAlgo(j, items, DEFAULT_BIN_SIZE);
                algo.fit();
                writeCSVLine(fileWriter, algo, items.size(), DEFAULT_BIN_SIZE);
            }
        }
        fileWriter.close();

    }

    private static void writeCSVHeader(FileWriter fileWriter) throws IOException {
        fileWriter.write("algo,tailleBins,nbElements,binsGenerated,timeElapsed,tauxRemplissage\n");
    }

    private static void writeCSVLine(FileWriter fileWriter, AbstractFitting algo, double nbElement, int size) throws IOException {
        String line = "" + algo.name() + "," + size + "," + nbElement + "," + algo.results().size() + "," +
                algo.getElapsedTime() + "," + DataParser.getTauxRemplissage(algo.results()) + "\n";
        fileWriter.write(line);
    }

    private static AbstractFitting initAlgo(int algoNumber, List<Item> items, int size) {
        AbstractFitting algo = null;

        switch (algoNumber) {
            case 0:
                algo =  new NextFit(items, size);
                break;
            case 1:
                algo =  new FirstFit(items, size);
                break;
            case 2:
                algo = new WorstFit(items, size);
                break;
            case 3:
                algo = new BestFit(items, size);
                break;
            case 4:
                algo = new AlmostWorstFit(items, size);
                break;
        }

        return algo;
    }

    private static List<Item> generateRandomList(double nbItems) {
        List<Item> items = new ArrayList<>();

        Random rand = new Random();
        for (double i = 0; i < nbItems; i++) {
            items.add(new Item(rand.nextInt(DEFAULT_BIN_SIZE)));
        }
        return items;
    }


}
