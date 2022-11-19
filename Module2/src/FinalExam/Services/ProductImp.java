package FinalExam.Services;

import FinalExam.Models.NhapKhau;
import FinalExam.Models.XuatKhau;
import FinalExam.Utils.WriteAndReadFile;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.WriteReadFileCSV;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductImp {
    public void addNewNhapKhau(NhapKhau nhapKhau){
        WriteAndReadFile.writeToFileProductNhapKhau(WriteAndReadFile.FILE_NHAPKHAU, nhapKhau );
        System.out.println("Write ro file CSV successful");
    }
    public void addNewXuatKhau(XuatKhau xuatKhau){
        WriteAndReadFile.writeToFileXuatKhau(WriteAndReadFile.FILE_XUATKHAU, xuatKhau);
        System.out.println("Write ro file CSV successful");
    }
    public void findNhapKhau(String id){
        List<NhapKhau> nhapKhauList = WriteAndReadFile.readNhapKhauCSV();
        for(NhapKhau nhapKhau: nhapKhauList){
            if(nhapKhau.getIdProduct().equals(id)){
                System.out.println(nhapKhau);
            }else {
                System.out.println("No product");
            }
        }
    }
    public void findXuatKhau(String id){
        List<XuatKhau> xuatKhauList = WriteAndReadFile.readXuatKhauCSV();
        for(XuatKhau xuatKhau: xuatKhauList){
            if(xuatKhau.getIdProduct().equals(id)){
                System.out.println(xuatKhau);
            }else {
                System.out.println("No product");
            }
        }
    }
}
