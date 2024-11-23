public class Vet implements Observer {
    @Override
    public void update(Pet pet) {
        System.out.println("Vet notified: New pet added - " + pet.getName() + " the " + pet.getType());
    }
}
