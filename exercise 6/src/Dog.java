 public class Dog extends Pet {
    public Dog(String name) {
        super(name, "Dog");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}
