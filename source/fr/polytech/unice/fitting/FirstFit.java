package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class FirstFit extends AbstractFitting {

    public FirstFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {

        long start = System.nanoTime();
        bins.add(new Bin(binSize));
        int i;

        for (Item item : items) {

            for (i = 0; i < bins.size(); i++) {
                if (bins.get(i).isFitting(item)) {
                    bins.get(i).addItem(item);
                    break;
                }

            }

            if (i >= bins.size()) {
                bins.add(i, new Bin(binSize));
                bins.get(i).addItem(item);
            }

        }

        long end = System.nanoTime();
        elapsedTime = end - start;
    }

    @Override
    public String name() {
        return "First_Fit";
    }
}
