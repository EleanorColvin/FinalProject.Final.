import java.util.ArrayList;

public class ArrayListMystery
{
    public static void main(String[] args)
    {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(5);
        numList.add(7);
        numList.add(8);
        numList.add(5);
        numList.add(6);
        numList.add(5);
        numList.add(4);
        numList.add(1);
        System.out.println(mystery(numList, 5)); // call from main method
    }

    public static int mystery(ArrayList<Integer> list, int num)
    {
        if (list.size() == 0)
        {
            return 0;
        }

        // recall the arraylist "remove" method returns the removed value, and we
        // can store in an int variable rather than Integer because of Java's
        // autoboxing and unboxing feature which converts between the two types
        // automatically
        int current = list.remove(0);

        if (current == num)
        {
            return 1 + mystery(list, num);
        }
        else
        {
            return mystery(list, num);
        }
    }
}
