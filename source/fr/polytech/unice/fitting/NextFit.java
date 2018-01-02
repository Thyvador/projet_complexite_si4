package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.Iterator;
import java.util.List;

public class NextFit extends AbstractFitting {


    public NextFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {
        long start = System.nanoTime();
        Iterator<Item> itemIterator = items.iterator();
        Item item = itemIterator.next();
        Bin bin = new Bin(binSize);
        bins.add(bin);
        while (itemIterator.hasNext()) {

            if (bin.isFitting(item)) {
                bin.addItem(item);
                item = itemIterator.next();
            } else {
                bin = new Bin(binSize);
                bins.add(bin);
            }

        }
        long end = System.nanoTime();
        elapsedTime = end - start;
    }
}
