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

public class ApodGUI implements ActionListener{
    private JTextField dataText;
    private Networking client;
    private JLabel img;
    private JLabel title;
    private JLabel imgDate;
    private JLabel explanation;
    private SpaceData data;

    public ApodGUI()
    {
        client = new Networking();
        dataText = new JTextField();
        img = new JLabel();
        title = new JLabel();
        imgDate = new JLabel();
        explanation = new JLabel();
        data = null;
        setup();
    }

    private void setup() {
        JFrame frame = new JFrame("Space App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel head = new JLabel("Astronomy Picture of the Day");
        head.setFont(new Font("Times", Font.PLAIN, 20));
        head.setForeground(Color.WHITE);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.add(head);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JLabel zip = new JLabel("Enter date(YYYY-MM-DD): ");
        zip.setForeground(Color.WHITE);
        dataText = new JTextField(8);
        JButton search = new JButton("SEARCH");
        JButton clear = new JButton("CLEAR");
        panel2.add(zip);
        panel2.add(dataText);
        panel2.add(search);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel2.add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        search.addActionListener(this);
        clear.addActionListener(this);

        JPanel panel3 = new JPanel();
        title = new JLabel("");
        imgDate = new JLabel("");
        img = new JLabel(new ImageIcon("src/placeholder.jpg"));
        panel3.add(title, BorderLayout.NORTH);
        panel3.add(imgDate, BorderLayout.NORTH);
        panel3.add(img, BorderLayout.CENTER);
        panel3.add(explanation/*, BorderLayout.SOUTH*/);
        panel3.add(img, BorderLayout.SOUTH);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.AFTER_LAST_LINE);

        frame.pack();
        frame.setVisible(true);
    }

    private void loadData(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("dateobj " + date);
        String strDate = sdf.format(date);
        System.out.println("Date entered: " + strDate);
        data = client.makeAPICall(strDate);
        title.setText(data.getTitle());
        explanation.setText(data.getExplanation());

        imgDate.setText("(" + strDate + ")");
        try {
            URL imageURL = new URL(data.getImgUrl());
            BufferedImage image = ImageIO.read(imageURL);
            ImageIcon icon = new ImageIcon(image);
            Image i = icon.getImage();

            Image resized = i.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon resizedIcon = new ImageIcon(resized);
            img.setIcon(resizedIcon);
        } catch (IOException e) { }

    }

    private void reset()
    {
        title.setText("");
        imgDate.setText("");
        explanation.setText("");
        img.setIcon(new ImageIcon("src/placeholder.jpg"));
    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());
        String text = button.getText();

        if (text.equals("SEARCH"))
        {
            String inputDate = dataText.getText();
            System.out.println("date en:" + inputDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(inputDate);
                System.out.println("d: "+ date);
                loadData(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (text.equals("CLEAR"))
        {
            dataText.setText("");
            reset();
        }
    }
}