package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class NextFit extends AbstractFitting {

    public NextFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {

        if (super.items.isEmpty()) return;

        long start = System.nanoTime();
        super.bins.add(new Bin(super.binSize));

        for (Item item : super.items) {

            if (!super.bins.get(0).isFitting(item))
                super.bins.add(0, new Bin(super.binSize));

            if (super.bins.get(0).isFitting(item)) /* in case the item size is superior to the bin size */
                super.bins.get(0).addItem(item);
        }

        long end = System.nanoTime();
        elapsedTime = end - start;
    }

    @Override
    public String name() {
        return "NextFit";
    }
}
