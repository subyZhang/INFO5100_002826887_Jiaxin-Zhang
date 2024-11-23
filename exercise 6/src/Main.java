//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PetManager petManager = PetManager.getInstance();

        Vet vet = new Vet();
        petManager.addObserver(vet);

        Pet dog = PetFactory.createPet("Dog", "Buddy");
        Pet cat = PetFactory.createPet("Cat", "Whiskers");


        petManager.addPet(dog);
        petManager.addPet(cat);

       
        System.out.println("All pets in the system:");
        for (Pet pet : petManager.getPets()) {
            System.out.println(pet.getName() + " the " + pet.getType());
            pet.makeSound();
        }

    }
}