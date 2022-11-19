package FinalExam.Controller;

import FinalExam.Models.NhapKhau;
import FinalExam.Services.ProductImp;
import FinalExam.Utils.CheckException;
import FinalExam.Utils.IDExcepion;
import FinalExam.Utils.WriteAndReadFile;
import OOP.Bai_tap.Fan.Main;

import java.util.List;
import java.util.Scanner;

public class NhapKhauController {
    public static ProductImp productImp = new ProductImp();
    public static MainController mainController = new MainController();
    Scanner input = new Scanner(System.in);
    public void addNewProductNhap(){
        try {
            int stt = mainController.sttNhapKhau();
            String id = IDExcepion.inputAndCheckId();
            String idProduct = "SP"+id;
            System.out.print("Ten san pham: ");
            String name = input.nextLine();
            System.out.print("Gia ban: ");
            long price = CheckException.price();
            System.out.print("So luong: ");
            int soluong = CheckException.soluong();
            System.out.print("Nha san xuat: ");
            String nhaSX = input.nextLine();
            System.out.print("Gia nhap khau: ");
            long priceNhap = CheckException.price();
            System.out.print("Tinh nhap khau: ");
            String tinh = input.nextLine();
            System.out.print("Thue nhap khau: ");
            long thue = CheckException.price();
            NhapKhau product = new NhapKhau(stt,idProduct, name, price,soluong,nhaSX,priceNhap,tinh,thue);
            productImp.addNewNhapKhau(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void displayNhapKhau(){
        List<NhapKhau> nhapKhauList = WriteAndReadFile.readNhapKhauCSV();
        for (NhapKhau nhapKhau: nhapKhauList){
            System.out.println(nhapKhau);
        }
    }
    public void findNhap(){
        System.out.println("Enter id product here");
        System.out.print("Ma san pham: SP");
        String id = IDExcepion.inputAndCheckId();
        String idProduct = "SP"+id;
        productImp.findNhapKhau(idProduct);
    }
    public void removeProduct(){
        System.out.println("Enter id product here");
        System.out.print("Ma san pham: SP");
        String id = IDExcepion.inputAndCheckId();
        String idProduct = "SP"+id;
    }
}
