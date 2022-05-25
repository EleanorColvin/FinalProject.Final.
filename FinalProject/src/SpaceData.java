import java.util.Date;
public class SpaceData {
    private String imgUrl;
    private String title;
    private Date date;

    public SpaceData(String imgUrl, String title, Date date) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.date = date;
    }

    public String getImgUrl() { return imgUrl; }
    public String getTitle() { return title; }
    public Date getData() { return date; }
}
