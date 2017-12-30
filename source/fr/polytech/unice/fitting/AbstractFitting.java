package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public abstract class AbstractFitting {
    List<Item> items;
    List<Bin> bins;

    public AbstractFitting(List<Item> items, List<Bin> bins) {
        this.items = items;
        this.bins = bins;
    }


    public abstract void fit() throws OverLoadedBinException;

    public void results() {

    }
}
