import java.util.ArrayList;
public class Main {
    public static void main(String [] args)
    {
        Pet pet1 = new Pet("floppy", "rabbit");
        Dog pet2 = new Dog("Arty", "Pug");

        PetOwner owner1 = new PetOwner(pet1, "Jerry");
        owner1.printOwnerInfo();
        PetOwner owner2 = new PetOwner(pet2, "Kris");
        owner2.printOwnerInfo();

    }
}
