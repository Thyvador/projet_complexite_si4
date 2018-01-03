package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class BestFit extends AbstractFitting {

    public BestFit(List<Item> items, int binSize) {
        super(items, binSize);
    }

    @Override
    public void fit() throws OverLoadedBinException {
        long start = System.nanoTime();
        for (Item item : items) {
            Bin bin = null;
            int i = 0;
            for (; i < bins.size(); i++) {
                if (bins.get(i).isFitting(item)) {
                    bin = bins.remove(i);
                    break;
                }
            }

            if (i >= bins.size() && bin == null) {
                bin = new Bin(binSize);
            }
            i--;
            bin.addItem(item);

            if (bins.size() == 0) i = -1;

            while (i >= 0 && bin.compareTo(bins.get(i)) < 0) {
                i--;
            }
            bins.add(i + 1, bin);

        }
        long end = System.nanoTime();
        elapsedTime = end - start;
    }


    @Override
    public String name() {
        return "Best_Fit";
    }
}
