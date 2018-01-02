package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFitting {
    protected List<Item> items;
    protected List<Bin> bins;
    protected int binSize;

    protected long elapsedTime;

    public AbstractFitting(List<Item> items, int binSize) {
        this.items = items;
        this.binSize = binSize;
        this.bins = new ArrayList<>();
    }


    public abstract void fit() throws OverLoadedBinException;

    public List<Bin> results() {
        return new ArrayList<>(bins);
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
