package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager(){}
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
                System.out.println("id: " + product.getIdProduct()+ "-name: "+ product.getNameProduct()+ "-price: "+product.getPriceProduct());
            }else {
                System.out.println("Not found");
            }
        }
    }
    public void sortPriceASC(){
        PriceASC priceASC = new PriceASC();
        Collections.sort(this.products,priceASC);
    }

    public void sortPriceDESC(){
        PriceDSC priceDESC = new PriceDSC();
        Collections.sort(this.products,priceDESC);
    }


}
