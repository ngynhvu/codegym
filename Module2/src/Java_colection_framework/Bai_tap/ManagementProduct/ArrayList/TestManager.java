package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;


public class TestManager {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product(1, "apple", 12000));
        productManager.addProduct(new Product(2, "banana", 23000));
        productManager.addProduct(new Product(3, "mango", 10000));
        productManager.displayProducts();
        productManager.editProduct(2, "phone", 23000000);
        productManager.displayProducts();
        productManager.removeProduct(1);
        productManager.displayProducts();
        productManager.findByNameProduct("mango");
        productManager.sortPriceASC();
        productManager.displayProducts();
        productManager.sortPriceDESC();
        productManager.displayProducts();

    }
}
