import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Main implements ActionListener{
    private JFrame game;
    private JButton ProjectChristmasButton;
    private JButton ChristmasShakedownButton;
    public void Start(){
        //startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        //ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
        game = new JFrame("Honker Launcher");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1280,760);
        game.setLocation(200,100);
        game.setVisible(true);
        //game.setIconImage(gameIcon.getImage());
        game.setFocusable(true);
        ChristmasShakedownButton = new JButton();
        ChristmasShakedownButton.setSize(100,210);
        ChristmasShakedownButton.setLocation(200,100);
        ChristmasShakedownButton.setVisible(true);
        ChristmasShakedownButton.setText("Christmas Shakedown: The Grinch Who Hooked a Who");
        ProjectChristmasButton = new JButton();
        ProjectChristmasButton.setSize(100,210);
        ProjectChristmasButton.setLocation(400,100);
        ProjectChristmasButton.setVisible(true);
        ProjectChristmasButton.setText("ProjectChristmas");
        game.add(ProjectChristmasButton);
        //game.add(ChristmasShakedownButton);
        // JButton button1 = new JButton();
        // button1.setLocation(400,100);
        // button1.setSize(100,200);
        // button1.setVisible(true);
        // button1.setText("Button1");
        // game.add(button1);
        game.update(game.getGraphics());
        ProjectChristmasButton.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}