public class Dice implements RollingObjects{
    private int sides;

    public Dice(int sides)
    {
        this.sides = sides;
    }

    public int getSides()
    {
        return sides;
    }

    public String roll()
    {
        return "You rolled a " + (((int) (Math.random() * sides) + 1));
    }
}
