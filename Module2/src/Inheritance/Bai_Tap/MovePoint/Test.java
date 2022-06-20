package Inheritance.Bai_Tap.MovePoint;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(3.0f , 4.6f);
        float[] result = point.getXY();
        System.out.println(Arrays.toString(result));
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(3.0f , 4.6f, 5.6f, 7.8f);
        float[] result1 = moveablePoint.getSpeed();
        System.out.println(Arrays.toString(result1));
        System.out.println(moveablePoint);
    }
}
