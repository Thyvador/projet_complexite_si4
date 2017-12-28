package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.Collection;

public abstract class AbstractFitting {
    Collection<Item> items;
    Collection<Bin> bins;

    public AbstractFitting(Collection<Item> items, Collection<Bin> bins) {
        this.items = items;
        this.bins = bins;
    }


    public abstract void fit() throws OverLoadedBinException;

    public void results() {

    }
}
