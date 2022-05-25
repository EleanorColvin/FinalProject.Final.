import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MusicNetworking {
    private String baseUrl;
    private String apiKey;

    public MusicNetworking() {
        baseUrl = "https://api.spotify.com/v1";
        apiKey = "16720664cd0048dab27ec58d5b037b9f";
    }

    public String makeAPICall(int num) {
        String endPoint = "/browse/new-releases";
        String url = baseUrl + endPoint + "shows?" + "&limit=" + num;

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

    public void parseInfo(String json) {
        JSONObject jsonObj = new JSONObject(json);
        JSONObject albumsArr = jsonObj.getJSONObject("albums");

        for (int i = 0; i < albumsArr.length(); i++) {
            JSONObject Album = albumsArr.get(i);
            JSONObject Obj = Info.getJSONObject("album");

           // System.out.println("Album: " + Album + ", Artist: " + Artist);
        }
      }
}
