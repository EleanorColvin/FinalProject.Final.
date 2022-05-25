public class Adder {
    private int value;

    public Adder(int startingValue)
    {
        value = startingValue;
    }

    public void add(int amt)
    {
        value += amt;
    }

    public int addFiveDouble()
    {
        value +=5;
        return 2 * value;
    }
}
