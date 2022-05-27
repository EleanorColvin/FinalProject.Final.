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
    private JTextArea explanation;
    private SpaceData data;
    private JFrame frame;

    public ApodGUI()
    {
        client = new Networking();
        dataText = new JTextField();
        img = new JLabel();
        title = new JLabel();
        imgDate = new JLabel();
        explanation = new JTextArea(6, 40);
        data = null;
        frame = new JFrame();
        setup();
    }

    private void setup() {
        JFrame frame = new JFrame("Space App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,700));

        JLabel head = new JLabel("Astronomy Picture of the Day");
        head.setFont(new Font("Times", Font.PLAIN, 20));
        head.setForeground(Color.WHITE);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.add(head);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JLabel dateEn = new JLabel("Enter date(YYYY-MM-DD): ");
        dateEn.setForeground(Color.WHITE);
        dataText = new JTextField(8);
        JButton search = new JButton("SEARCH");
        JButton clear = new JButton("CLEAR");
        panel2.add(dateEn);
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
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setBackground(Color.LIGHT_GRAY);
        explanation.setWrapStyleWord(true);
        explanation.setEditable(false);
        explanation.setLineWrap(true);
        explanation.setBackground(Color.LIGHT_GRAY);
        title = new JLabel("");
        imgDate = new JLabel("");
        img = new JLabel(new ImageIcon("src/placeholder.jpg"));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        imgDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(title);
        panel3.add(imgDate);
        panel3.add(img);
        panel3.add(explanation);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setBounds(200,200,200,200);
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
frame.pack();
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