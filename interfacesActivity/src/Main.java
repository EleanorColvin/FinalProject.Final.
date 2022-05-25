import java.util.ArrayList;
public class Main {
    public static void main(String []args)
    {
        Dice d1 = new Dice(6);
        Dice d2 = new Dice(12);
        Dice d3 = new Dice(20);

        BowlingBall b1 = new BowlingBall("Blue");
        BowlingBall b2 = new BowlingBall("Pink");
        BowlingBall b3 = new BowlingBall("Green");

        ArrayList<RollingObjects> arr = new ArrayList <>();
        arr.add(d1);
        arr.add(d2);
        arr.add(d3);
        arr.add(b1);
        arr.add(b2);
        arr.add(b3);

        for (RollingObjects r : arr)
        {
            System.out.println(r.roll());
        }
    }
}
