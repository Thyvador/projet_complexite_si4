package fr.polytech.unice;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.fitting.AbstractFitting;
import fr.polytech.unice.fitting.BestFit;
import fr.polytech.unice.fitting.NextFit;
import fr.polytech.unice.fitting.WorstFit;
import fr.polytech.unice.utils.DataParser;
import fr.polytech.unice.utils.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainStat {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String runAgain;
            do {
                System.out.println("Size of bins : ");
                int size = sc.nextInt();
                System.out.println("Nb of items : ");
                int itemsNb = sc.nextInt();
                List<Item> items = new ArrayList<>();
                Random rand = new Random();
                for (int i = 0; i < itemsNb; i++) {
                    items.add(new Item(rand.nextInt(size)));
                }

                for (int i = 0; i < 3; i++) {
                    runAlgo(items, size, i);
                }
                System.out.println("Run again ?(Y/N)");
                runAgain = sc.next();
            } while (runAgain == "y" || runAgain == "Y");
        } catch (IOException | OverLoadedBinException e) {
            e.printStackTrace();
        }
    }

    private static void runAlgo(List<Item> items, int size, int i) throws OverLoadedBinException, IOException {
        AbstractFitting algo;
        switch (i) {
            case 0:
                algo = new NextFit(items, size);
                break;
            case 1:
                algo = new BestFit(items, size);
                break;
            case 2:
                algo = new WorstFit(items, size);
                break;
            default:
                return;
        }
        algo.fit();
        DataParser.writeResult(algo);
    }
}
