package Java_colection_framework.Bai_tap.ManagementProduct.ArrayList;


import java.util.Scanner;

public class TestManager {
        ProductManager productManager = new ProductManager();

    public static void menu(){
            System.out.println("Product Management");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Find product");
            System.out.println("4. Remove product");
            System.out.println("5. Sort product");
            System.out.println("6. Return menu");
            System.out.println("Enter your choice: ");
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product(1, "anh", 20000));
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 6) {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    productManager.displayProducts();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
