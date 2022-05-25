public class BowlingBall implements RollingObjects {
    private String color;
    public BowlingBall(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public String roll()
    {
        Double i = Math.random();

        if (i < .33) {
            return "Strike";
        }
        else if (i < .66)
        {
            return "miss";
        }
        else
        {
            return ((int) (Math.random() * 9 + 1)) + " down";
        }
    }
}
