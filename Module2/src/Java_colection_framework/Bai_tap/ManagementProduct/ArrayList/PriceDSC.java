package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;

import java.util.Comparator;

public class PriceDSC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPriceProduct() - o1.getPriceProduct());
    }
}
