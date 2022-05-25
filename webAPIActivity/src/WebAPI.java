import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class WebAPI {
    public static void main(String[] args)
    {
        String APIkey = "4d2342454ffe40382aa96b0624361cc3";
        String urlMostPopular = "https://api.themoviedb.org/3/tv/popular?api_key=" + APIkey + "&language=en-US&page=1";
        makeAPICall(urlMostPopular);

        System.out.print("Which show (enter ID)? ");
        Scanner scan = new Scanner(System.in);
        String showID = scan.nextLine();

        String showURL = "https://api.themoviedb.org/3/tv/" + showID + "?api_key=" + APIkey + "&language=en-US&page=1";
        makeAPICall(showURL);
    }

    public static void makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.statusCode());
            //System.out.println(response.headers());
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

