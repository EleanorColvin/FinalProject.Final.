public class MusicAPI {

    private MusicNetworking networker;

    public MusicAPI() {
        this.networker = new MusicNetworking();
    }

    public void newReleases(int num)
    {
        String response = networker.makeAPICall(num);
        //networker.parseInfo(response);
    }
}
