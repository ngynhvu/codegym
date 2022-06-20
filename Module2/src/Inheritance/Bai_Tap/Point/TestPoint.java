package Inheritance.Bai_Tap.Point;

import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(10.0f, 1.0f);
        float[] result = point2D.getXY();
        System.out.println(point2D);
        System.out.println(Arrays.toString(result));

        Point3D point3D = new Point3D(10.0f, 1.0f,3.0f);
        float[] result2 = point3D.getXYZ();
        System.out.println(point3D);
        System.out.println(Arrays.toString(result2));
    }
}
