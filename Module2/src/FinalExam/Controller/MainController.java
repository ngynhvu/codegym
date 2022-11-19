package FinalExam.Controller;

import FinalExam.Models.NhapKhau;
import FinalExam.Models.XuatKhau;
import FinalExam.Utils.WriteAndReadFile;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static NhapKhauController nhapKhauController = new NhapKhauController();
    public static XuatKhauController xuatKhauController = new XuatKhauController();
    public int sttNhapKhau(){
        int count = 1;
        List<NhapKhau> nhapKhauList = WriteAndReadFile.readNhapKhauCSV();
        if (nhapKhauList.isEmpty()){
            return count;
        }else {
            for(NhapKhau nhapKhau: nhapKhauList){
                count++;
            }
            return count;
        }
    }
    public int sttXuatKhau(){
        int count = 1;
        List<XuatKhau> xuatKhauList = WriteAndReadFile.readXuatKhauCSV();
        if (xuatKhauList.isEmpty()){
            return count;
        }else {
            for(XuatKhau xuatKhau: xuatKhauList){
                count++;
            }
            return count;
        }
    }
    public static void displayTypeProduct(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("1. Add product nhap khau");
            System.out.println("2. Add product xuat khau");
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    nhapKhauController.addNewProductNhap();
                    break;
                case 2:
                    xuatKhauController.addNewProductXuat();
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void findTypeProduct(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("1. Find product nhap khau");
            System.out.println("2. Find product xuat khau");
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    nhapKhauController.findNhap();
                    break;
                case 2:
                    xuatKhauController.findXuat();
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 5) {
            System.out.println("CHUONG TRINH QUAN LY SAN PHAM");
            System.out.println("1. Add new Product");
            System.out.println("2. Remove product");
            System.out.println("3. Display list product");
            System.out.println("4. Find product");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    displayTypeProduct();
                    break;
                case 2:
                    break;
                case 3:
                    nhapKhauController.displayNhapKhau();
                    xuatKhauController.displayXuatKhau();
                    break;
                case 4:
                    findTypeProduct();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}
