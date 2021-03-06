import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GUI implements ActionListener
{
    private Networking client;
    private JButton catButton;
    private JButton duckButton;
    private JButton foxButton;
    private JButton dogButton;
    private JFrame frame;
    private Sound sound;
    private JCheckBox soundsCheck;

    public GUI()
    {
        frame = new JFrame("Animal App");
        sound = new Sound();
        client = new Networking(); // our "networking client"
        catButton = new JButton("Cat");
        duckButton = new JButton("Duck");
        foxButton = new JButton("Fox");
        dogButton = new JButton("Dog");
        soundsCheck = new JCheckBox("Sounds");
        setupGui();
    }

    private void setupGui()
    {
        //Creating a Frame
        frame.setLocation(800, 40);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // ends program when you hit the X

        // Creating an image from a jpg file stored in the src directory

        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        JLabel welcomeLabel = new JLabel("Animals!");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(r, g, b));

        JPanel logoWelcomePanel = new JPanel(); // the panel is not visible in output
        logoWelcomePanel.add(welcomeLabel);
        logoWelcomePanel.setVisible(true);


        //bottom panel with text field and buttons
        JPanel entryPanel = new JPanel(); // the panel is not visible in output
        JPanel checkBoxPanel = new JPanel();
        entryPanel.add(catButton);
        entryPanel.add(dogButton);
        entryPanel.add(duckButton);
        entryPanel.add(foxButton);
        checkBoxPanel.add(soundsCheck);



        //Adding Components to the frame
        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(entryPanel);
        frame.add(checkBoxPanel, BorderLayout.AFTER_LAST_LINE);

        // PART 2 -- SET UP EVENT HANDLING
        //setting up buttons to use ActionListener interface and actionPerformed method
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        foxButton.addActionListener(this);
        duckButton.addActionListener(this);

        // showing the frame
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(catButton))
        {
            try
            {
                URL imageURL = new URL(client.parseCat(client.makeRequest(client.CATURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame("Cat");
                int x = (int) (Math.random() * 1300) + 200;
                int y = (int) (Math.random() * 500) + 100;
                woo.setLocation(x, y);
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\cat.mp3");
                }

            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }

        }
        else if(e.getSource().equals(dogButton))
        {
            try
            {
                URL imageURL = new URL(client.parseDog(client.makeRequest(client.DOGURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame("Dog");
                int x = (int) (Math.random() * 1300) + 200;
                int y = (int) (Math.random() * 500) + 100;
                woo.setLocation(x, y);
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\dog.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
        else if(e.getSource().equals(duckButton))
        {
            try
            {
                URL imageURL = new URL(client.parseDuck(client.makeRequest(client.DUCKURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame("Duck");
                int x = (int) (Math.random() * 1300) + 200;
                int y = (int) (Math.random() * 500) + 100;
                woo.setLocation(x, y);
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\duck.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
        else if(e.getSource().equals(foxButton))
        {
            try
            {
                URL imageURL = new URL(client.parseFox(client.makeRequest(client.FOXURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame("Fox");
                int x = (int) (Math.random() * 1300) + 200;
                int y = (int) (Math.random() * 500) + 100;
                woo.setLocation(x, y);
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\fox.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
    }
}
