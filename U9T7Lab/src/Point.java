public class Point {
    private int x;
    private int y;
    private String label;

    public Point(String label, int x, int y) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof Point))
        {
            return false;
        }
            Point temp = (Point) o;
            return (x == temp.x && y == temp.y);

    }

    @Override
    public String toString()
    {
        return "Point " + label + " is at x = " + x + "  y = " + y;
    }

}
