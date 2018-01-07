package fr.polytech.unice.utils;

import java.util.ArrayList;
import java.util.List;

class Node {

    private List<Bin> bins;
    private Node left;
    private Node right;

    Node(Bin bin) {
        this.bins = new ArrayList<>();
        this.add(bin);
        this.left = this.right = null;
    }

    boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    void add(Bin bin) {
        this.bins.add(bin);
    }

    Bin remove() {
        return this.bins.remove(0);
    }

    Bin getBin() {
        return this.bins.get(0);
    }

    public void setBins(List<Bin> bins) {
        this.bins = bins;
    }

    List<Bin> getBins() {
        return this.bins;
    }

    Node getRight() {
        return right;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    boolean gotRight() {
        return this.right != null;
    }
}