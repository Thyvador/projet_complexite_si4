package fr.polytech.unice.fitting;

import fr.polytech.unice.exception.OverLoadedBinException;
import fr.polytech.unice.utils.BST;
import fr.polytech.unice.utils.Bin;
import fr.polytech.unice.utils.Item;

import java.util.List;

public class WorstFit extends AbstractFitting {

    private BST tree;

    public WorstFit(List<Item> items, int binSize) {
        super(items, binSize);
        this.tree = new BST(new Bin(super.binSize));

    }

    @Override
    public void fit() throws OverLoadedBinException {

        if (super.items.isEmpty()) return;

        long start = System.nanoTime();
        super.bins.add(new Bin(super.binSize));

        for (Item item : super.items) {

            Bin bin = this.tree.searchWorst();

            if (!bin.isFitting(item)) {
                bin = new Bin(super.binSize);
                super.bins.add(bin);
            } else {
                this.tree.delete(bin);
            }

            bin.addItem(item);

            this.tree.insert(bin);

        }

        long end = System.nanoTime();
        super.elapsedTime = end - start;

    }

    @Override
    public String name() {
        return "Worst_Fit";
    }

}
