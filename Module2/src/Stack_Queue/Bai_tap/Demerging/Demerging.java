package Stack_Queue.Bai_tap.Demerging;

import sun.awt.image.ImagingLib;

import java.util.LinkedList;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        Person person[] = new Person[7];
        person[0] = new Person("Hoang Tien Anh",true,"18/01/2001");
        person[1] = new Person("Hoang Tien Anh",true,"18/01/2001");
        person[2] = new Person("Hoang Tien Anh",false,"18/01/2001");
        person[3] = new Person("Hoang Tien Anh",true,"18/01/2001");
        person[4] = new Person("Hoang Tien Anh",false,"18/01/2001");
        person[5] = new Person("Hoang Tien Anh",false,"18/01/2001");
        person[6] = new Person("Hoang Tien Anh",true,"18/01/2001");
        Queue<Person> Male = new LinkedList<>();
        Queue<Person> Female = new LinkedList<>();
        System.out.println("Before sort: ");
        for(Person personnelValue: person){
            System.out.println(personnelValue.toString());
            if (personnelValue.isSex()){
                Male.add(personnelValue);
            }else{
                Female.add(personnelValue);
            }
        }

        String ouput = "";

        while (!Female.isEmpty()){
            ouput += Female.poll().toString() +"\n";
        }

        while (!Male.isEmpty()){
            ouput += Male.poll().toString()+"\n";
        }

        System.out.println("After sort: ");
        System.out.println(ouput);
    }
}
