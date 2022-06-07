import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Networking {
    private String baseUrl;
    private String apiKey;

    public Networking()
    {
        baseUrl = "https://api.nasa.gov";
        apiKey = "ChGru1xCDJYi5YmudxgcHmLXvLIrDWCOZofTbIEm";
    }

    public SpaceData makeAPICall(String date)
    {
        System.out.println("calling Api...");
        String endPoint = "/planetary/apod";
        String url = baseUrl + endPoint + "?date=" + date + "&api_key=" + apiKey;
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

    public SpaceData parseData(String json) throws ParseException
    {
        JSONObject jsonObj = new JSONObject(json);
        String title = jsonObj.getString("title");
        String dateStr = jsonObj.getString("date");
        String explanation = jsonObj.getString("explanation");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dateStr);
        String imgUrl = jsonObj.getString("hdurl");
        SpaceData data = new SpaceData(imgUrl, title, explanation, date);
        return data;
    }
}