 public class Cat extends Pet {
    public Cat(String name) {
        super(name, "Cat");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}
