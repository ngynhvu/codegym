package IO_text_file.Bai_tap.CopyFile;

import java.io.*;

public class CopyFIle {
    public void CopyFile(String source, String target){

        try{
            File fileSource = new File(source);
            File fileTarget = new File(target);

            if(!fileSource.exists()){
                throw  new FileNotFoundException();
            }

            if(fileTarget.createNewFile()){
                System.out.println("File created "+target);
            }else {
                System.out.println("File already "+target);
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
            FileWriter fileWriter = new FileWriter(target);

            String line = "";

            while ((line = bufferedReader.readLine()) != null){
                fileWriter.write(line+"\n");
            }

            bufferedReader.close();
            fileWriter.close();


        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        CopyFIle copyFileText = new CopyFIle();
        String source = "E:\\CodeGym\\Module2\\result.txt";
        String target = "E:\\CodeGym\\Module2\\src\\IO_text_file\\Bai_tap\\CopyFile\\number.txt";
        copyFileText.CopyFile(source,target);
    }
}
