public class PetOwner
{
    private Pet thePet;
    private String owner;

    public PetOwner(Pet p, String o)
    {
        thePet = p;
        owner = o;
    }

    public void printOwnerInfo()
    {
        if (thePet instanceof Dog)
        {
            ((Dog) thePet).printPetInfo();
        }
        else
        {
            thePet.printPetInfo();
        }
        System.out.println(" owned by " + owner);
    }

}
