package annotation.exercise1;

// Child class Dog that extends Animal
public class Dog extends Animal {

    // Override the makeSound method from the Animal class
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

