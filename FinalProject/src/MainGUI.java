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
    public class MainGUI implements ActionListener{
        //private Networking client;
        public MainGUI()
        {
            setup();
        }

        private void setup()
        {
            JFrame frame = new JFrame("Space App");
            frame.setMinimumSize(new Dimension(300,175));
            JLabel l = new JLabel("SPACE APP");
            l.setForeground(Color.WHITE);

            JPanel p1 = new JPanel();
            p1.setForeground(Color.darkGray);
            p1.setBackground(Color.black);
            p1.add(l);


            JPanel p2 = new JPanel();
            p2.setBackground(Color.lightGray);
            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

            JTextArea introText = new JTextArea("Welcome to my space app. Here you can search for data from nasa " +
                    "about the astronomy picture of the day or the Spirit, Curiosity, and Opportunity Rovers. Enjoy!");
            introText.setEditable(false);
            introText.setLineWrap(true);
            introText.setWrapStyleWord(true);
            introText.setBackground(Color.lightGray);
            introText.setForeground(Color.blue);
            introText.setAlignmentX(Component.CENTER_ALIGNMENT);
            p2.add(introText);

            JPanel p3 = new JPanel();
            p3.setBackground(Color.green);
            p3.setForeground(Color.lightGray);

            JButton opp1 = new JButton("Rover Data");
            opp1.setForeground(Color.WHITE);
            opp1.setBackground(Color.BLACK);
            JButton opp2 = new JButton("APOD Data");
            opp2.setForeground(Color.WHITE);
            opp2.setBackground(Color.BLACK);
            p3.add(opp1);
            p3.add(opp2);
            opp1.addActionListener(this);
            opp2.addActionListener(this);


            frame.add(p1, BorderLayout.NORTH);
            frame.add(p2, BorderLayout.CENTER);
            frame.add(p3, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) (e.getSource());
            String text = button.getText();

            if (text.equals("Rover Data")) {
                RoverGUI rover = new RoverGUI();
            }
            else {
                ApodGUI apod = new ApodGUI();
            }

        }


}
