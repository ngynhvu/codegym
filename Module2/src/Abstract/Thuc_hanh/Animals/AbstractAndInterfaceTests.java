package Abstract.Thuc_hanh.Animals;

import Abstract.Thuc_hanh.Animals.animal.Animal;
import Abstract.Thuc_hanh.Animals.animal.Chicken;
import Abstract.Thuc_hanh.Animals.animal.Tiger;
import Abstract.Thuc_hanh.Animals.fruit.Apple;
import Abstract.Thuc_hanh.Animals.fruit.Fruit;
import Abstract.Thuc_hanh.Animals.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
