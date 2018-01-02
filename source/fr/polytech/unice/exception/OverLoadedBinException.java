package fr.polytech.unice.exception;

public class OverLoadedBinException extends Exception {
    public OverLoadedBinException(int freeSpace, int load) {
        super("Espace libre : " + freeSpace + ", charge : " + load);
    }
}
