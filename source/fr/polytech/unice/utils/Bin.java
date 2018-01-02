package fr.polytech.unice.utils;

import fr.polytech.unice.exception.OverLoadedBinException;

import java.util.ArrayList;
import java.util.Collection;

public class Bin implements Comparable {
    //TODO check si oon peut passer en int
    private int space;
    private int freeSpace;
    private Collection<Item> items;

    public Bin(int space) {
        this.space = space;
        freeSpace = space;
        //TODO Est ce que c'est le plus opti ?
        items = new ArrayList<>();
    }

    public int space() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public boolean isFitting(Item item) {
        return item.size() < freeSpace;
    }

    public boolean isEmpty() {
        return this.space == this.freeSpace;
    }

    public void addItem(Item item) throws OverLoadedBinException {
        if (freeSpace < item.size()) {
            throw new OverLoadedBinException(freeSpace, item.size());
        }
        items.add(item);
        freeSpace -= item.size();
    }

    @Override
    public int compareTo(Object o) {
        Bin bin = (Bin) o;
        return this.space - bin.space;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "space=" + space +
                ", freeSpace=" + freeSpace +
                ", items=" + items +
                '}';
    }
}
