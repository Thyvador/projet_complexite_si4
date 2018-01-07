package fr.polytech.unice.utils;

public class Item implements Comparable {

    private int size;

    public Item(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }

    @Override
    public int compareTo(Object o) {
        Item item = (Item) o;
        return this.size - item.size;
    }
}
