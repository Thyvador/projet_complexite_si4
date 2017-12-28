package fr.polytech.unice.utils;

import fr.polytech.unice.exception.OverLoadedBinException;

import java.util.ArrayList;
import java.util.Collection;

public class Bin {
    //TODO check si oon peut passer en int
    private double space;
    private double freeSpace;
    private Collection<Item> items;

    public Bin(double space) {
        this.space = space;
        freeSpace = space;
        //TODO Est ce que c'est le plus opti ?
        items = new ArrayList<>();
    }

    public double space() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public boolean isFitting(Item item){
        return item.size() < freeSpace;
    }

    public void addItem(Item item) throws OverLoadedBinException {
        if (freeSpace < item.size()){
            throw new OverLoadedBinException(freeSpace, item.size());
        }
        items.add(item);
        freeSpace -= item.size();
    }
}
