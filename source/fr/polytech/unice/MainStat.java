package fr.polytech.unice;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.fitting.*;
import fr.polytech.unice.utils.DataParser;
import fr.polytech.unice.utils.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainStat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String runAgain = "y";
        int size = 0, itemsNb = 0;
        boolean printDetailsBool = false;
        try {
            while (runAgain.equals("y") || runAgain.equals("r")) {
                switch (runAgain) {
                    case "y":
                        System.out.println("Size of bins : ");
                        size = sc.nextInt();
                        System.out.println("Nb of items : ");
                        itemsNb = sc.nextInt();
                        System.out.println("Print Details ? (y/n)");
                        String printDetails = sc.next();
                        printDetailsBool = printDetails.equals("Y") || printDetails.equals("y");
                    case "r":
                        List<Item> items = new ArrayList<>();
                        Random rand = new Random();
                        System.out.println("Size of bins : " + size);
                        for (int i = 0; i < itemsNb; i++) {
                            items.add(new Item(rand.nextInt(size)));
                        }
                        System.out.println("Items : \n" + items.toString());
                        for (int i = 0; i <= 4; i++) {
                            runAlgo(items, size, i, printDetailsBool);
                        }
                        break;
                    default:

                }
                System.out.println("Run statistics again ?\t\t\t(y) to run again\t\t\t" +
                        "(r) to run with the same configuration\t\t\t () any key to quit");
                runAgain = sc.next();
            }
        } catch (IOException | OverLoadedBinException e) {
            e.printStackTrace();
        }
    }

    private static void runAlgo(List<Item> items, int size, int i, boolean details) throws OverLoadedBinException, IOException {
        AbstractFitting algo;
        switch (i) {
            case 0:
                algo = new NextFit(items, size);
                break;
            case 1:
                algo = new FirstFit(items, size);
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
            default:
                return;
        }
        algo.fit();
        DataParser.writeResult(algo);
        if (details) DataParser.printDetails(algo);
    }
}
