package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class WorstFit extends AbstractFitting {


    public WorstFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {

        if (super.items.isEmpty()) return;

        long start = System.nanoTime();
        super.bins.add(new Bin(super.binSize));

        for (Item item : super.items) {

            Bin bin = (super.bins.get(0).isFitting(item)) ? super.bins.remove(0) : new Bin(super.binSize);

            if (bin.isFitting(item)) {
                bin.addItem(item);
                int i = 0;
                while (bin.compareTo(bins.get(i)) < 0) i++;
                super.bins.add(i, bin);
            }
        }

        long end = System.nanoTime();
        super.elapsedTime = end - start;

    }
}
