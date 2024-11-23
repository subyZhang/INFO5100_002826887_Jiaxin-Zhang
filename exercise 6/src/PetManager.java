import java.util.ArrayList;
import java.util.List;


 public class PetManager {
    private static PetManager instance;
    private List<Pet> pets;
    private List<Observer> observers;

    private PetManager() {
        pets = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static PetManager getInstance() {
        if (instance == null) {
            instance = new PetManager();
        }
        return instance;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        notifyObservers(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Pet pet) {
        for (Observer observer : observers) {
            observer.update(pet);
        }
    }
}