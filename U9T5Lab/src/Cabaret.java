import java.util.ArrayList;
public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer p)
    {
        if (performers.indexOf(p) == -1)
        {
            performers.add(p);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean removePerformer(Performer p)
    {
        if (performers.indexOf(p) == -1)
        {
            return false;
        }
        else
        {
            performers.remove(p);
            return true;
        }
    }

    public double averagePerformerAge()
    {
        int sum = 0;
        for (Performer p : performers)
        {
            sum+= p.getAge();
        }
        return (double) sum / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> performersOverAge = new ArrayList<>();
        for (Performer p : performers)
        {
            if(p.getAge() >= age)
            {
                performersOverAge.add(p);
            }
        }
        return performersOverAge;
    }

    public void groupRehearsal()
    {
        for (Performer p : performers)
        {
            System.out.println("RHEARSAL CALL! " + p.getName());
            if (p instanceof Dancer || p instanceof Performer)
            {
                p.rehearse();
            }
            else if (p instanceof Comedian)
            {
                ((Comedian) p).rehearse(false);
            }
        }
    }

    public void cabaretShow() {
        for (Performer p : performers) {
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());
            if (p instanceof Dancer) {
                ((Dancer) p).pirouette(2);
            }
            p.perform();
        }
    }

}
