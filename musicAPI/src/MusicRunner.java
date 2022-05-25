import java.util.Scanner;
public class MusicRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of albums you would like to see: ");
        int num = s.nextInt();

        MusicAPI api = new MusicAPI();
        api.newReleases(num);
    }
}
