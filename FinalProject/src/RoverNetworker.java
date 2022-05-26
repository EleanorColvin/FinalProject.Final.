import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.ArrayList;

public class RoverNetworker {
//    private String baseUrl;
//    private String apiKey;
//
//    public RoverNetworker()
//    {
//        baseUrl = "https://api.nasa.gov";
//        apiKey = "ChGru1xCDJYi5YmudxgcHmLXvLIrDWCOZofTbIEm";
//    }
//
//    public ArrayList<RoverData> getRovers()
//    {
//        String endpoint = "/manifests/rover_name.";
//        String url = baseUrl + endpoint + "?api_key=" + apiKey;
//
//        String response = makeAPICall(url);
//
//        RoverData rover = parseData(response);
//        return rover;
//
//
//    }
//
//    public String makeAPICall(String url)
//    {
//        try {
//            URI myUri = URI.create(url);
//            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
//            HttpClient client = HttpClient.newHttpClient();
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            return response.body();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    public RoverData parseData(String json)
//    {
//        JSONObject jsonObj = new JSONObject(json);
//        String name = jsonObj.getString("name");
//        String landingDate = jsonObj.getString("landing_date");
//        String launchDate = jsonObj.getString("launch_date");
//        int totalPhotos = jsonObj.getInt("total_photos");
//        RoverData data = new RoverData(name, landingDate, launchDate, totalPhotos);
//        return data;
//    }
}