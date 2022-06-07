import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.awt.Image;

public class RoverGUI implements ActionListener{
    private RoverNetworker client;
    private JLabel roverName;
    private JLabel launch;
    private JLabel photos;
    private JLabel img;
    private RoverData data;
    private JFrame frame;

    public RoverGUI()
    {
        client = new RoverNetworker();
        roverName = new JLabel();
        launch = new JLabel();
        photos = new JLabel();
        img = new JLabel();
        data = null;
        frame = new JFrame();
        setup();
    }

    private void setup() {
        JFrame frame = new JFrame("Rover App");
        frame.setMinimumSize(new Dimension(500,600));

        JLabel head = new JLabel("Rover Data");
        head.setFont(new Font("Times", Font.PLAIN, 20));
        head.setForeground(Color.WHITE);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.add(head);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        JButton cur = new JButton("CURIOSITY");
        JButton opp = new JButton("OPPORTUNITY");
        JButton spi = new JButton("SPIRIT");
        panel2.add(cur);
        cur.setBackground(Color.BLACK);
        cur.setForeground(Color.WHITE);
        panel2.add(opp);
        opp.setBackground(Color.BLACK);
        opp.setForeground(Color.WHITE);
        panel2.add(spi);
        spi.setBackground(Color.BLACK);
        spi.setForeground(Color.WHITE);

        cur.addActionListener(this);
        opp.addActionListener(this);
        spi.addActionListener(this);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setBackground(Color.LIGHT_GRAY);
        roverName = new JLabel("");
        roverName.setFont(new Font("Times", Font.PLAIN, 20));
        launch = new JLabel("");
        photos = new JLabel("");
        img = new JLabel(new ImageIcon("src/placeholder.jpg"));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        roverName.setAlignmentX(Component.CENTER_ALIGNMENT);
        launch.setAlignmentX(Component.CENTER_ALIGNMENT);
        photos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(roverName);
        panel3.add(launch);
        panel3.add(photos);
        panel3.add(img);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setBounds(200,200,200,200);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadData(String name) {
        data = client.makeAPICallRover(name);
        roverName.setText("ROVER: " + name);
        launch.setText("LAUNCH: " + data.getLaunch());
        photos.setText("TOTAL PHOTOS TAKEN: " + data.getPhotos());
        try {
            String imageURL = new String(data.getImg());
            if(!imageURL.substring(0, 5).equals("https"))
            {
                imageURL = imageURL.substring(0, 4) + "s" + imageURL.substring(4);
            }
            URL url = new URL(imageURL);
            BufferedImage image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            Image i = icon.getImage();

            Image resized = i.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon resizedIcon = new ImageIcon(resized);
            img.setIcon(resizedIcon);
        } catch (IOException e) { }
        frame.pack();
    }

    private void reset()
    {
        roverName.setText("");
        launch.setText("");
        photos.setText("");
        img.setIcon(new ImageIcon("src/placeholder.jpg"));
    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());
        String text = button.getText();

        if (text.equals("CURIOSITY"))
        {
            String input = "Curiosity";
            loadData(input);
        } else if (text.equals("OPPORTUNITY"))
        {
            String input = "Opportunity";
            loadData(input);
        }
        else
        {
            String input = "Spirit";
            loadData(input);
        }
    }
}