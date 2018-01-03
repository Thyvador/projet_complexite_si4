package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class BestFit2 extends AbstractFitting {

    public BestFit2(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {

        if (super.items.isEmpty()) return;

        long start = System.nanoTime();

        for (Item item : super.items) {

            int i = 0;
            while (i < super.bins.size() && !super.bins.get(i).isFitting(item)) i++;

            Bin bin = (i == super.bins.size()) ? new Bin(super.binSize) : super.bins.remove(i);

            if (bin.isFitting(item)) {  /* in case the item size is superior to the bin size */
                bin.addItem(item);
                i = (i == super.bins.size()) ? 0 : i;
                while (i < super.bins.size() && (bin.getFreeSpace() - super.bins.get(i).getFreeSpace()) > 0) i++;
                super.bins.add(i, bin);
            }


        }

        long end = System.nanoTime();
        super.elapsedTime = end - start;

    }

    @Override
    public String name() {
        return "Best_Fit";
    }

}
