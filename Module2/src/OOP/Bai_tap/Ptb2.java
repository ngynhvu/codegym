package OOP.Bai_tap;

import java.util.Scanner;

public class Ptb2 {
    public static class QuadraticEquation{
        private double a;
        private double b;
        private double c;
        public QuadraticEquation(){
        }
        public QuadraticEquation(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant(){
            return (this.b*this.b + 4*this.a*this.c);
        }
        public  double getRoot(){
            return -this.c/this.b;
        }
        public double getRoot12(){
            return -this.b/(2*this.a);
        }
        public double getRoot1() {
            return (-this.b -Math.sqrt(getDiscriminant()))/(2*this.a);
        }
        public double getRoot2(){
            return (-this.b + Math.sqrt(getDiscriminant()))/(2*this.a);
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if(quadraticEquation.a == 0){
            if(quadraticEquation.b == 0){
                System.out.println("Phương trình vô sốn nghiệm");
            }else {
                System.out.println("Phương trình có nghiệm duy nhất: "+ quadraticEquation.getRoot());
            }
        }else {
            if(quadraticEquation.getDiscriminant() < 0){
                System.out.println("Phương trình vô nghiệm");
            }else {
                if(quadraticEquation.getDiscriminant() == 0){
                    System.out.println("Phương trình nghiệm kép" + quadraticEquation.getRoot12());
                }else {
                    System.out.printf("Phương trình có 2 nghiệm phân biệt x1= %f và x2 = %f", quadraticEquation.getRoot1(), quadraticEquation.getRoot2());
                }
            }
        }
    }
}
