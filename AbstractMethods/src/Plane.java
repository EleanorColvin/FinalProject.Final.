public class Plane extends Vehicle{
    public Plane(int passengers, String type)
    {
        super(passengers, "Plane");
    }

    public void fly()
    {
        System.out.println("flying...");
    }


}
