package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFitting {

    List<Item> items;
    List<Bin> bins;
    int binSize;

    long elapsedTime;

    AbstractFitting(List<Item> items, int binSize) {
        this.items = items;
        this.binSize = binSize;
        this.elapsedTime = 0;
        this.bins = new ArrayList<>();
    }

    public abstract void fit() throws OverLoadedBinException;

    public List<Bin> results() {
        return new ArrayList<>(bins);
    }

    public int binSize() {
        return binSize;
    }

    public int itemCount() {
        return items.size();
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public abstract String name();
}
