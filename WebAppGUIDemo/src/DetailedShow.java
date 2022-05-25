// a subclass of Movie, in which additional details are added
public class DetailedShow extends Show
{
    private String overview;
    private double popularity;
    private String firstAirDate;
    private String posterPath;

    public DetailedMovie(String title, int id, String overview, double popularity,
                         String firstAirDate, String posterPath)
    {
        super(title, id);
        this.overview = overview;
        this.popularity = popularity;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
    }

    public String getOverview() { return overview; }
    public double getPopularity() { return popularity; }
    public String getReleaseDate() { return firstAirDate; }
    public String getPosterPath() { return posterPath; }
}
