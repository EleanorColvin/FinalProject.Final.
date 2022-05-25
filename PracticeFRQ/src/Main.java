import java.util.ArrayList;
public class Main {
    public static void main(String[] args)
    {
        ArrayList<Integer> arr =  new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            arr.add((int)Math.random() * 10 + 1);
        }

        for (int j = 0; j < arr.size(); j++)
        {
            if(arr.get(j) % 2 == 0)
            {
                arr.set(j, arr.get(j) * 2);
            }
            else
            {
                arr.remove(j);
                j--;
            }
        }

        for(int k = 0; k < arr.size(); k+= 2)
        {
            arr.add(k + 1, arr.get(k) * -1);
        }

        int[][] arr2D = new int[5][4];
        int idx = 0;
        for (int r = 0; r < arr2D.length; r++)
        {
            for (int c = 0; c < arr2D[0].length; c++)
            {
                if (idx < arr.size())
                {
                    arr2D[r][c] = arr.get(idx);
                    idx++;
                }
            }
        }

    }

}
