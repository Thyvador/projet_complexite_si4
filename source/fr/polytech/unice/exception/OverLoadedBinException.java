package fr.polytech.unice.exception;

public class OverLoadedBinException extends Exception {
    public OverLoadedBinException(double freeSpace, double load) {
        super("Espace libre : " + freeSpace + ", charge : " + load);
    }
}
