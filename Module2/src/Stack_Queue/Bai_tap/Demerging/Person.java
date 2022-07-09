package Stack_Queue.Bai_tap.Demerging;

public class Person {
    private String name;
    public static final boolean MALE = true, FEMALE = false;
    private boolean sex;
    private String dateOfBirth;
     public Person(){}

    public Person(String name, boolean sex, String dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }
    public String getSex(){
         if(isSex())return "Male";
         else return "Female";
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
