package fr.polytech.unice.utils;

import fr.polytech.unice.exception.OverLoadedBinException;

import java.util.ArrayList;
import java.util.Collection;

public class Bin implements Comparable {

    private int space;
    private int freeSpace;
    private Collection<Item> items;

    public Bin(int space) {
        this.space = space;
        freeSpace = space;
        items = new ArrayList<>();
    }

    public int freeSpace() {
        return this.freeSpace;
    }

    public boolean isFitting(Item item) {
        return item.size() <= freeSpace;
    }

    public void addItem(Item item) throws OverLoadedBinException {
        if (freeSpace < item.size()) {
            throw new OverLoadedBinException(freeSpace, item.size());
        }
        items.add(item);
        freeSpace -= item.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bin bin = (Bin) o;

        if (space != bin.space) return false;
        if (freeSpace != bin.freeSpace) return false;
        return items != null ? items.equals(bin.items) : bin.items == null;
    }

    @Override
    public int hashCode() {
        int result = space;
        result = 31 * result + freeSpace;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        Bin bin = (Bin) o;
        return this.freeSpace - bin.freeSpace;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "space=" + space +
                ", freeSpace=" + freeSpace +
                ", items=" + items +
                '}';
    }

    public int itemsCount() {
        return items.size();
    }

}
