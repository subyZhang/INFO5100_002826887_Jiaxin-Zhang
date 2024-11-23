 public class PetFactory {
    public static Pet createPet(String type, String name) {
        switch (type) {
            case "Dog":
                return new Dog(name);
            case "Cat":
                return new Cat(name);
            default:
                throw new IllegalArgumentException("Unknown pet type.");
        }
    }
}
