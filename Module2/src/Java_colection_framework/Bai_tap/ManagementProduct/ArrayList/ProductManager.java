package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager(){}
    public ProductManager(ArrayList<Product> products) {
        this.products = products;
    }

    public void displayProducts(){
        System.out.println("List of Products: ");
        for(Product product: products){
            System.out.println(product.toString());
        }
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public void editProduct(int id,String name, long price){
        Product productEdit = new Product(id, name, price);
        for (Product product : products){
            if(product.getIdProduct() == id){
                product.setNameProduct(name);
                product.setPriceProduct(price);
                break;
            }
        }
    }
    public void removeProduct(int id){
        products.remove(id);
    }
    public void findByNameProduct(String name){
        for (Product product: products){
            if(product.getNameProduct() == name){

            }
        }
    }

}
