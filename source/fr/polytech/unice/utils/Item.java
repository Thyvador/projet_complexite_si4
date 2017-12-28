package fr.polytech.unice.utils;

public class Item {
    //TODO Check si on peut changer en int.
    private double size;

    public Item(double size) {
        this.size = size;
    }

    public double size() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
