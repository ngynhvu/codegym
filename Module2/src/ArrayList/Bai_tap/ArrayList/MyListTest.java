package ArrayList.Bai_tap.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ok");
        list.add("no");
        list.add("yes");
        String json = "";
        for(int i = 0; i<list.size()-1;i++){
            String item = "{\n" +
                    "      \"name\": \""+list.get(i)+"\"\n" +
                    "    }";
            json = json + item +",";
        }
        json = json + "{\n" +
                "      \"name\": \""+list.get(list.size()-1)+"\"\n" +
                "    }";
        System.out.println(json);
    }
}
