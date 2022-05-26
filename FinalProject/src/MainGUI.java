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
            JFrame frame = new JFrame();
            JLabel l = new JLabel("IDK");
            l.setBackground(Color.darkGray);

            JPanel p1 = new JPanel();
            p1.setForeground(Color.darkGray);
            p1.setBackground(Color.lightGray);
            p1.add(l);

            //JPanel p2 = new JPanel();

            JPanel p3 = new JPanel();
            p3.setBackground(Color.darkGray);
            p3.setForeground(Color.lightGray);

            JButton opp1 = new JButton("opp1");
            opp1.setForeground(Color.WHITE);
            opp1.setBackground(Color.BLACK);
            JButton opp2 = new JButton("opp2");
            opp2.setForeground(Color.WHITE);
            opp2.setBackground(Color.BLACK);
            p3.add(opp1);
            p3.add(opp2);
            opp1.addActionListener(this);
            opp2.addActionListener(this);


            frame.add(p1, BorderLayout.NORTH);
            frame.add(p3, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            ApodGUI apod = new ApodGUI();
        }


}
