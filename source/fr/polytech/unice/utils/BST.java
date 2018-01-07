package fr.polytech.unice.utils;

import java.util.List;

public class BST {

    private Node root;

    public BST(Bin bin) {
        this.root = new Node(bin);
    }

    public Bin searchBest(Item item) {
        return searchBestRec(root, item).getBin();
    }

    private Node searchBestRec(Node root, Item item) {

        if (root == null) return null;

        if (item.size() < root.getBin().freeSpace())
            root.setLeft(searchBestRec(root.getLeft(), item));
        else if (item.size() > root.getBin().freeSpace())
            root.setRight(searchBestRec(root.getRight(), item));
        else if (item.size() == root.getBin().freeSpace())
            return root;

        return root;
    }

    public Bin searchWorst() {
        return searchWorstRec(root).getBin();
    }

    private Node searchWorstRec(Node root) {
        if (!root.gotRight()) return root;
        return searchWorstRec(root.getRight());
    }

    public void insert(Bin bin) {
        this.root = insertRec(root, bin);
    }

    private Node insertRec(Node root, Bin bin) {

        if (root == null) {
            root = new Node(bin);
            return root;
        }

        if (bin.compareTo(root.getBin()) < 0)
            root.setLeft(insertRec(root.getLeft(), bin));
        else if (bin.compareTo(root.getBin()) > 0)
            root.setRight(insertRec(root.getRight(), bin));
        else if (bin.compareTo(root.getBin()) == 0)
            root.add(bin);

        return root;
    }

    public void delete(Bin bin) {
        this.root = deleteRec(this.root, bin);
    }

    private Node deleteRec(Node root, Bin bin) {

        if (bin.compareTo(root.getBin()) < 0) {
            root.setLeft(deleteRec(root.getLeft(), bin));
        } else if (bin.compareTo(root.getBin()) > 0) {
            root.setRight(deleteRec(root.getRight(), bin));
        } else {
            if (root.getBins().size() > 1) {
                root.remove();
            } else {
                if (root.getLeft() == null)
                    return root.getRight();
                else if (root.getRight() == null)
                    return root.getLeft();

                root.setBins(minValue(root.getRight()));
                root.setRight(deleteRec(root.getRight(), root.getBins()));
            }
        }

        return root;
    }

    private Node deleteRec(Node root, List<Bin> bins) {

        if (bins.get(0).compareTo(root.getBin()) < 0) {
            root.setLeft(deleteRec(root.getLeft(), bins));
        } else if (bins.get(0).compareTo(root.getBin()) > 0) {
            root.setRight(deleteRec(root.getRight(), bins));
        } else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            root.setBins(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getBins()));
        }

        return root;
    }

    private List<Bin> minValue(Node root) {

        List<Bin> minv = root.getBins();
        while (root.getLeft() != null) {
            minv = root.getLeft().getBins();
            root = root.getLeft();
        }

        return minv;
    }

    private void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println(root.getBin());
            inorderRec(root.getRight());
        }
    }

}