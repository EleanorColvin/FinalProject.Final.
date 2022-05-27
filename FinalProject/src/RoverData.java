public class RoverData {
        private int photos;
        private String roverName;
        private String landing;
        private String launch;

        public RoverData(String roverName, String landing, String launch, int photos) {
            this.roverName = roverName;
            this.landing = landing;
            this.launch = launch;
            this.photos = photos;
        }

        public String getName{ return roverName; }
        public String getLanding() { return landing; }
        public String getLaunch() { return launch; }
        public int getPhotos() { return photos; }
    }

}
