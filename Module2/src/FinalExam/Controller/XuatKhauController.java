package FinalExam.Controller;


import FinalExam.Models.NhapKhau;
import FinalExam.Models.XuatKhau;
import FinalExam.Services.ProductImp;
import FinalExam.Utils.CheckException;
import FinalExam.Utils.IDExcepion;
import FinalExam.Utils.WriteAndReadFile;

import java.util.List;
import java.util.Scanner;

public class XuatKhauController {
    public static ProductImp productImp = new ProductImp();
    public static MainController mainController = new MainController();
    Scanner input = new Scanner(System.in);
    public void addNewProductXuat(){
        try {
            int stt = mainController.sttXuatKhau();
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
            System.out.print("Gia xuat khau: ");
            long priceXuat = CheckException.price();
            System.out.print("Quoc gia nhap khau: ");
            String quocGia = input.nextLine();
            XuatKhau product = new XuatKhau(stt,idProduct, name, price,soluong,nhaSX,priceXuat,quocGia);
            productImp.addNewXuatKhau(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void displayXuatKhau(){
        List<XuatKhau> xuatKhauList = WriteAndReadFile.readXuatKhauCSV();
        for (XuatKhau xuatKhau: xuatKhauList){
            System.out.println(xuatKhau);
        }
    }
    public void findXuat(){
        System.out.println("Enter id product here");
        System.out.print("Ma san pham: SP");
        String id = IDExcepion.inputAndCheckId();
        String idProduct = "SP"+id;
        productImp.findXuatKhau(idProduct);
    }
}
