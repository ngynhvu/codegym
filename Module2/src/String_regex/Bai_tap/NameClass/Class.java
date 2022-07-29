package String_regex.Bai_tap.NameClass;

public class Class {
    public static void main(String[] args) {
        String regex = "^[C|A|P]\\d{4}[G,H,I,K,L,M]$";
        System.out.println("C0318G".matches(regex));
        System.out.println("A0318H".matches(regex));
        System.out.println("M0318G".matches(regex));
        System.out.println("P0323A".matches(regex));
    }
}
