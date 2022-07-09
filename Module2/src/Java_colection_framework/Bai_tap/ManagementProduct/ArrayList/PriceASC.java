package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;

import java.util.Comparator;

public class PriceASC implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product1.getPriceProduct() - product2.getPriceProduct());
    }

}
