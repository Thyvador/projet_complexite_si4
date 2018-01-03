package fr.polytech.unice.utils;

public class Item {
    //TODO Check si on peut changer en int.
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
}
