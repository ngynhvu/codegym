package Abstract.Bai_tap.Colorable;

public class TestMain {
    public static void main(String[] args) {
        Square[] square = new Square[3];
        square[0] = new Square(3.0);
        square[1] = new Square(4.5);
        square[2] = new Square(2.3);
        System.out.println("Before");
        for (Square s: square) {
            System.out.println(s);
        }
        System.out.println("After");
        for (Square s: square) {
            System.out.println(s.howToColor());
        }
    }
}
