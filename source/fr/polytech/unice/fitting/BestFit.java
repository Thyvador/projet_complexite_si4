package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BestFit extends AbstractFitting {

    public BestFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {
        long start = System.nanoTime();
        Iterator<Item> itemIterator = items.iterator();
        bins.add(new Bin(binSize));
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            int i = 0;
            for (; i < bins.size(); i++) {
                if (bins.get(i).isFitting(item)) {
                    bins.get(i).addItem(item);
                    sortList(i);
                    break;
                }

            }
            if (i >= bins.size() - 1){
                bins.add(i, new Bin(binSize));
                sortList(i);
            }
        }
        long end = System.nanoTime();
        elapsedTime = end - start;
    }

    private void sortList(int i){
        Bin bin = bins.get(i);
        for (int j = i; bin.compareTo(bins.get(i)) < 0 || j > 0; j--) {}
        bins.remove(bin);
        bins.add(i, bin);
    }

    @Override
    public String name() {
        return "BestFit";
    }
}
