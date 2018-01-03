package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

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
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            int i = 0;
            for (; i < bins.size(); i++) {
                if (bins.get(i).isFitting(item)) {
                    break;
                }

            }
            if (i >= bins.size() - 1 && itemIterator.hasNext()) {
                bins.add(i, new Bin(binSize));
            }

            bins.get(i).addItem(item);
            sortList(i);
        }
        long end = System.nanoTime();
        elapsedTime = end - start;
    }

    private void sortList(int i) {
        Bin bin = bins.get(i);
        int j = i;
        while (j > 0) {
            j--;
            if (bin.compareTo(bins.get(j)) < 0) {
                bins.remove(bin);
                bins.add(j, bin);
            }
        }

    }

    @Override
    public String name() {
        return "Best_Fit";
    }
}
