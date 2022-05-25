public class Dog extends Pet {
    private String breed;

    public Dog(String name, String breed) {
        super(name, "Dog");
        this.breed = breed;
    }

    @Override
    public void printPetInfo() {
        super.printPetInfo();
        System.out.print(" of breed " + breed);
    }
}
