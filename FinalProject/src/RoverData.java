public class RoverData {
        private int photos;
        private String name;
        private String launch;

        public RoverData(String name, String launch, int photos) {
            this.name = name;
            this.launch = launch;
            this.photos = photos;
        }

        public String getName() { return name; }
        public String getLaunch() { return launch; }
        public int getPhotos() { return photos; }
    }

