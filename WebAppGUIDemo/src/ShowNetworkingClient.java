import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// this class is used for making network calls to the Movie Database API,
// specifically the Get Now Playing and Get Movie Details endpoints,
// and parsing the JSON responses into objects
public class ShowNetworkingClient {

    private String APIkey;
    private String baseUrl;

    public ShowNetworkingClient()
    {
        APIkey = "4d2342454ffe40382aa96b0624361cc3";
        baseUrl = "https://api.themoviedb.org/3";
    }

    // gets the list of movies now playing
    // by making an API call to the Get Now Playing API endpoint,
    // parsing the JSON data, then returning an arraylist of Movie objects
    public ArrayList<Show> getMostPopular()
    {
        String endPoint = "/movie/now_playing";
        String urlMostPopular = baseUrl + endPoint + "?api_key=" + APIkey;

        // use the makeAPICall helper method to make a network request to the Now Playing API
        String response = makeAPICall(urlMostPopular);

        // call the parseNowPlayingJSON helper method, then return
        // the arraylist of Movie objects that gets returned by that helper method
        ArrayList<Show> mostPopularShows = parseNowPlayingJSON(response);
        return mostPopularShows;
    }

    // gets movie details for a particular movie ID
    // by making an API call to the Get Movie Details API endpoint,
    // parsing the JSON data, then returning a DetailedMovie object
    public DetailedMovie getShowDetails(int showID)
    {
        String endPoint = "/movie/" + showID;
        String urlMovieDetails = baseUrl + endPoint + "?api_key=" + APIkey;

        // use the makeAPICall helper method to make a network request to the Movie Details API
        String response = makeAPICall(urlShowDetails);

        // call the parseMovieDetailsJSON helper method, then return
        // the DetailedMovie object that gets returned by that helper method
        DetailedShow detailed = parseShowDetailJSON(response);
        return detailed;
    }

    // private helper method; makes an API call to the provided url
    // and returns the response body (JSON) as a String
    private String makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // private helper method; parses a Now Playing JSON
    // string and returns an arraylist of Movie objects;
    // this method is called from the getNowPlaying method shown above
    private ArrayList<Show> parseNowPlayingJSON(String json)
    {
        ArrayList<Show> shows = new ArrayList<Show>();

        JSONObject jsonObj = new JSONObject(json);
        JSONArray showList = jsonObj.getJSONArray("results");

        for (int i = 0; i < showList.length(); i++)
        {
            JSONObject movieObj = showList.getJSONObject(i);
            String movieTitle = movieObj.getString("title");
            int movieID = movieObj.getInt("id");
            Show show = new Show(movieTitle, movieID);
            shows.add(show);
        }
        return shows;
    }

    // private helper method; parses a Get Movie Details JSON
    // string and returns a DetailedMovie object;
    // this method is called from the getMovieDetails method shown above
    private DetailedMovie parseMovieDetailJSON(String json)
    {
        JSONObject jsonObj = new JSONObject(json);
        String movieTitle = jsonObj.getString("title");
        int movieID = jsonObj.getInt("id");
        String overview = jsonObj.getString("overview");
        String tagline = jsonObj.getString("tagline");
        double popularity = jsonObj.getDouble("popularity");
        String releaseDate = jsonObj.getString("release_date");
        String posterPath = jsonObj.getString("poster_path");
        String fullPosterPath = "https://image.tmdb.org/t/p/w500" + posterPath;

        DetailedMovie detailedShow = new DetailedShow(movieTitle, movieID, overview, popularity, releaseDate, fullPosterPath);
        return detailedShow;
    }
}