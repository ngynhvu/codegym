package Inheritance.Bai_Tap.Circle;

public class TestMain {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(4.0,"red" );
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(5.0, "pink", 2.0);
        System.out.println(cylinder);
    }
}
