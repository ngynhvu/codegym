public class student {
    private String name;
    private int tuoi;
    public student(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
