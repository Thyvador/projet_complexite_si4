package fr.polytech.unice.utils;

import fr.polytech.unice.fitting.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataParser {

    public static AbstractFitting parseData(String path, int type) throws IOException {
        List<Item> items = new ArrayList<>();

        BufferedReader reader = Files.newBufferedReader(Paths.get(path));
        reader.readLine();
        int size = Integer.parseInt(reader.readLine());
        reader.readLine();
        String buf = reader.readLine();
        for (String s : buf.split(",")) {
            items.add(new Item(Integer.parseInt(s.replaceAll("\\D", ""))));
        }

        // ON PEUT TRIER ICI
//        Collections.sort(items, Collections.reverseOrder());
//        Collections.sort(items, Collections.reverseOrder());
        switch (type) {
            case 0:
                return new NextFit(items, size);
            case 1:
                return new FirstFit(items, size);
            case 2:
                return new WorstFit(items, size);
            case 3:
                return new BestFit(items, size);
            case 4:
                return new AlmostWorstFit(items, size);
            default:
                return null;
        }
    }

    public static void writeResult(AbstractFitting abstractFitting) {
        System.out.println(
                String.format("%1$-" + 20    + "s", abstractFitting.name()) +
                        String.format("%1$-" + 12 + "s", abstractFitting.binSize() + " units") +
                        String.format("%1$-" + 16 + "s", abstractFitting.itemCount() + " items") +
                        String.format("%1$-" + 16 + "s", abstractFitting.results().size() + " bins") +
                        String.format("%1$-" + 16 + "s", (abstractFitting.getElapsedTime() / 1000) + " ms") +
                        String.format("%1$-" + 16 + "s", getTauxRemplissage(abstractFitting.results()) + " %")
        );
    }


    public static String getTauxRemplissage(List<Bin> bins) {
        double taux = 0;

        for (Bin bin: bins) {
            taux += bin.getTauxRemplissage();
        }
        taux = taux * 100;
        return String.format("%.2f", taux / bins.size());
    }


    public static void printDetails(AbstractFitting abstractFitting){
        abstractFitting.results().forEach(System.out::println);
    }
}
