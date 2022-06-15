package SS5.Bai_tap.AccessModifier;
public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(4.0);
        Circle circle2 = new Circle(1.0);
        Circle circle3 = new Circle(3.0);

        System.out.printf("Circle have: %f and Area: %f", circle1.getRadius(), circle1.getArea());
        System.out.printf("Circle have: %f and Area: %f", circle2.getRadius(), circle3.getArea());
        System.out.printf("Circle have: %f and Area: %f", circle3.getRadius(), circle3.getArea());

    }
}
