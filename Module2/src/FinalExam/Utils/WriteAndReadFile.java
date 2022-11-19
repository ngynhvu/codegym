package FinalExam.Utils;

import FinalExam.Models.NhapKhau;
import FinalExam.Models.XuatKhau;
import FuramaResort.Models.Person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    public static final String FILE_NHAPKHAU="E:\\CodeGym\\Module2\\src\\FinalExam\\Data\\nhapkhau.csv";
    public static final String FILE_XUATKHAU="E:\\CodeGym\\Module2\\src\\FinalExam\\Data\\xuatkhau.csv";
    public static void writeToFileProductNhapKhau(String path,NhapKhau nhapKhau) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(nhapKhau.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFileXuatKhau(String path, XuatKhau xuatKhau) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(xuatKhau.simpleString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<NhapKhau> readNhapKhauCSV() {
        List<NhapKhau> nhapKhauList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_NHAPKHAU);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            NhapKhau nhapKhau;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                int stt = Integer.parseInt(temp[0]);
                String id = temp[1];
                String name = temp[2];
                long price = Long.parseLong(temp[3]);
                int sl = Integer.parseInt(temp[4]);
                String nsx = temp[5];
                long priceNhap = Long.parseLong(temp[3]);
                String tinh = temp[7];
                long giaNhap = Long.parseLong(temp[8]);
                nhapKhau = new NhapKhau(stt,id,name,price,sl,nsx, priceNhap,tinh,giaNhap);
                nhapKhauList.add(nhapKhau);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nhapKhauList;
    }
    public static List<XuatKhau> readXuatKhauCSV() {
        List<XuatKhau> xuatKhauList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_XUATKHAU);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            XuatKhau xuatKhau;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                int stt = Integer.parseInt(temp[0]);
                String id = temp[1];
                String name = temp[2];
                long price = Long.parseLong(temp[3]);
                int sl = Integer.parseInt(temp[4]);
                String nsx = temp[5];
                long priceXuat = Long.parseLong(temp[3]);
                String quocGia = temp[7];
                xuatKhau = new XuatKhau(stt,id,name,price,sl,nsx, priceXuat,quocGia);
                xuatKhauList.add(xuatKhau);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return xuatKhauList;
    }

}
