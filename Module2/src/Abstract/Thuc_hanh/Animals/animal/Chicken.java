package Abstract.Thuc_hanh.Animals.animal;

import Abstract.Thuc_hanh.Animals.Edible;
import Abstract.Thuc_hanh.Animals.animal.Animal;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
