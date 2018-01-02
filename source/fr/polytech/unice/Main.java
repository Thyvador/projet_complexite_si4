package fr.polytech.unice;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.fitting.AbstractFitting;
import fr.polytech.unice.utils.DataParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            AbstractFitting algo = DataParser.parseData("C:\\Users\\alexh\\IdeaProjects\\projet_complexite_si4\\exemples\\exemple1000.txt", 1);
            algo.fit();
            DataParser.writeResult(algo);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (OverLoadedBinException e) {
            e.printStackTrace();
        }
    }
}
