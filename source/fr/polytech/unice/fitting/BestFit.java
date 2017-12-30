package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BestFit extends AbstractFitting {
    public BestFit(List<Item> items, List<Bin> bins) {
        super(items, bins);
    }

    @Override
    public void fit() throws OverLoadedBinException {
        //TODO :: Check sort dans le bon sens
        Collections.sort(bins);
        Iterator<Item> itemIterator = items.iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            for (int i = 0; i < bins.size(); i++) {
                if (bins.get(i).isFitting(item)) {
                    bins.get(i).addItem(item);
                    Bin bin = bins.get(i);
                    bins.remove(bin);
                    for (; bin.compareTo(bins.get(i)) < 0; i++) {
                        bins.add(i, bin);
                    }
                }
            }
        }
    }
}
