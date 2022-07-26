package BinaryFile_Serialization.Bai_tap.ManageProducts;

import BinaryFile_Serialization.Thuc_hanh.ReadAndWrite.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
            List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = readDataFromFile("product.txt");
        List<Product> productList = new ArrayList<>();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Display Product");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    int id = Integer.parseInt(input.nextLine());
                    String name = input.nextLine();
                    String manufacturer = input.nextLine();
                    double price = Double.parseDouble(input.nextLine());
                    String otherDescription = input.nextLine();
                    productList.add(new Product(id,name,manufacturer,price,otherDescription));
                    writeToFile("product.txt", productList);

                    break;
                case 2:
                   for(Product product: products){
                       System.out.println(product);
                   }
                    break;
                case 3:
                    String nameFind = input.nextLine();
                    for(Product product: products){
                        if(product.getNameProduct() == nameFind){
                            System.out.println(product);
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
