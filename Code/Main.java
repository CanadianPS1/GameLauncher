import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Main implements ActionListener{
    private JFrame game;
    public void Start(){
        //this is an example of how you would get an image into it, then you just cast it into the create bit of the button
        //startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        //ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
        game = new JFrame("Honker Launcher");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1280,760);
        game.setLocation(200,100);
        game.setVisible(true);
        game.setFocusable(true);
        game.setLayout(null);
        CreateMainMenu();
    }
    public void CreateGrinchMenu(){
        MakeButton(200, 100, 200, 500, "~Play Grinch~");
        MakeLabel(200,310,200,100,Color.lightGray,"Grinch");
        MakeLabel(600,210,500,150,Color.lightGray,"Grinch Game Discription");
        MakeButton(100,50,1000,550,"~back~");
        game.update(game.getGraphics());
    }
    public void CreateProjectChristmasMenu(){
        MakeButton(200, 100, 200, 500, "~Play Christmas~");
        MakeLabel(200,310,200,100,Color.lightGray,"Project Christmas");
        MakeLabel(600,210,500,150,Color.lightGray,"Project Christmas Game Discription");
        MakeButton(100,50,1000,550,"~back~");
        game.update(game.getGraphics());
    }
    public void WipeScene(){
        Component[] components = game.getContentPane().getComponents();
        for(Component component : components){
            component.setVisible(false);
        }
        game.update(game.getGraphics());
        System.out.println("Scene Wiped");
    }
    public void CreateMainMenu(){
        MakeButton(200,310,350,200,"~Project Christmas~");
        MakeButton(200,310,700,200,"~Christmas Shakedown: The Grinch Who Hooked a Who~");
        MakeButton(100,50,580,550,"~exit~");
        //MakeLabel(1280,760,0,0,Color.DARK_GRAY,"");
        game.update(game.getGraphics());
    }
    //youll have to add a image into here when you make it
    public void MakeButton(int width, int height, int x, int y, String text){
        JButton button = new JButton();
        button.setBounds(x,y,width,height);
        button.setVisible(true);
        button.setText(text);
        button.addActionListener((ActionListener) this);
        game.add(button);
    }
    //you can use this to place images
    public void MakeLabel(int width, int height, int x, int y, Color color, String text){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setText(text);
        label.setBackground(color);
        label.setOpaque(true);
        game.add(label);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e + "";
        if(event.contains("~Christmas Shakedown: The Grinch Who Hooked a Who~")){
            System.out.println("Christmas Shakedown Button Pressed");
            WipeScene();
            CreateGrinchMenu();
        }else if(event.contains("~Project Christmas~")){
            System.out.println("Project Christmas Button Pressed");
            WipeScene();
            CreateProjectChristmasMenu();
        }else if(event.contains("~Play Grinch~")){
            ProcessBuilder grinch = new ProcessBuilder("GameLauncher\\Games\\ChristmasShakedown\\Christmas Shakedown The Grinch who Hooked a Who.exe");
            try{
                grinch.start();
            }catch(IOException ex){
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }else if(event.contains("~Play Christmas~")){
            ProcessBuilder grinch = new ProcessBuilder("GameLauncher\\Games\\ProjectSanta\\Project Santa.exe");
            try{
                grinch.start();
            }catch(IOException ex){
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }else if(event.contains("~back~")){
            WipeScene();
            CreateMainMenu();
        }else if(event.contains("~exit~")){
            System.exit(0);
        }
    }
}