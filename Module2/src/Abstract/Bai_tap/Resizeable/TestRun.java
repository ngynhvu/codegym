package Abstract.Bai_tap.Resizeable;

import Abstract.Thuc_hanh.Comparator.CircleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class TestRun {
    public static void main(String[] args) {
        double x = Math.floor(Math.random() * 10);
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);
        System.out.println("Pre-resize:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        System.out.println("After-resize:");
        for (Circle circle : circles) {
            circle.resize(x);
            System.out.println(circle);
        }
    }
}
