package BinaryFile_Serialization.Bai_tap.CopyBinaryFile;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sourcePath = "E:\\CodeGym\\Module2\\src\\BinaryFile_Serialization\\Bai_tap\\CopyBinaryFile\\result.csv";
        String destPath = "E:\\CodeGym\\Module2\\src\\BinaryFile_Serialization\\Bai_tap\\CopyBinaryFile\\result1.csv";


        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            //copyFileUsingStream(sourceFile, destFile);
            System.out.printf("Copy completed");
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
}
