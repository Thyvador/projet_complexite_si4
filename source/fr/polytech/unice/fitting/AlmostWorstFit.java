package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class AlmostWorstFit extends AbstractFitting {


    public AlmostWorstFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {
        if (super.items.isEmpty()) return;

        long start = System.nanoTime();
        super.bins.add(new Bin(super.binSize));

        int i = 0;
        for (Item item : super.items) {
            Bin bin = getSecondEmptiestBin(item);

            if (bin.isFitting(item)) {  /* in case the item size is superior to the bin size */
                i = 0;
                bin.addItem(item);
                while (i < super.bins.size() && (bin.getFreeSpace() - super.bins.get(i).getFreeSpace()) < 0) i++;
                super.bins.add(i, bin);
            }
        }

        long end = System.nanoTime();
        super.elapsedTime = end - start;

    }

    private Bin getSecondEmptiestBin(Item item) {
        Bin bin;

        if (bins.size() > 1 && secondEmptiestBinIsFitting(item)) {
            bin = super.bins.remove(1);
        } else {
            bin = (super.bins.get(0).isFitting(item)) ? super.bins.remove(0) : new Bin(super.binSize);
        }

        return bin;
    }

    private boolean secondEmptiestBinIsFitting(Item item) {
        return super.bins.get(1).isFitting(item);
    }

    @Override
    public String name() {
        return "Almost_Worst_Fit";
    }
}
