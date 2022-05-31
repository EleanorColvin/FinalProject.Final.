import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RoverNetworker {
    private String baseUrl;
    private String apiKey;

    public RoverNetworker()
    {
        baseUrl = "https://api.nasa.gov";
        apiKey = "ChGru1xCDJYi5YmudxgcHmLXvLIrDWCOZofTbIEm";
    }

    public RoverData makeAPICallRover(String name)
    {
        System.out.println("calling Api...");
        String endPoint = "/mars-photos/api/v1/manifests/";
        String url = baseUrl + endPoint + name + "/&api_key=" + apiKey;
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseData(response.body());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public RoverData makeAPICallSol(String name, int sol)
    {
        System.out.println("calling Api...");
        String endPoint = "/mars-photos/api/v1/rovers/";
        String url = baseUrl + endPoint + name + "/photos?sol=" + sol + "/?api_key=" + apiKey;
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseData(response.body());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public RoverData parseData(String json)
    {
        JSONObject jsonObj = new JSONObject(json);
        System.out.println(jsonObj);
        JSONObject o = jsonObj.getJSONObject("photo_manifest");
        String name = o.getString("name");
        System.out.println("name" + name);
        String launch = o.getString("launch_date");
        System.out.println("launch" + launch);
        int photos = o.getInt("total_photos");
        int sol = o.getInt("max_sol");
        JSONObject j = new JSONObject(makeAPICallSol(name, sol));
        JSONObject p = j.getJSONObject("photos");
        String imgSrc = p.getString("img_src");
        System.out.println("photos" + photos);
        System.out.println("Parsing...");
        RoverData data = new RoverData(name, launch, photos);
        return data;
    }
}