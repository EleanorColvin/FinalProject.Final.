public class RoverData {
        private int photos;
        private String name;
        private String launch;
        private String img;

        public RoverData(String name, String launch, int photos, String img) {
            this.name = name;
            this.launch = launch;
            this.photos = photos;
            this.img = img;
        }

        public String getName() { return name; }
        public String getLaunch() { return launch; }
        public int getPhotos() { return photos; }
        public String getImg() { return img; }
    }

