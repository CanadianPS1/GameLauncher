import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Main implements ActionListener{
    private static final Color PLAY_BUTTON_COLOR = new Color(34, 139, 34);
    private static final Color PLAY_BUTTON_BORDER = new Color(18, 92, 18);
    private static final Color EXIT_BUTTON_COLOR = new Color(196, 43, 43);
    private static final Color EXIT_BUTTON_BORDER = new Color(122, 24, 24);
    private static final Color APP_BACKGROUND_COLOR = new Color(224, 247, 250);
    private static final Color SELECTION_BUTTON_BORDER = new Color(45, 45, 45);
    private static final Color SELECTION_BUTTON_FALLBACK = new Color(210, 210, 210);
    private static final Color TITLE_PANEL_BACKGROUND = new Color(242, 252, 255);
    private static final Color TITLE_PANEL_BORDER = new Color(88, 148, 160);
    private static final Color TITLE_TEXT_COLOR = new Color(32, 92, 105);
    private static final Color DESCRIPTION_PANEL_BACKGROUND = new Color(239, 252, 255);
    private static final Color DESCRIPTION_PANEL_BORDER = new Color(104, 168, 180);
    private static final Color DESCRIPTION_TEXT_COLOR = new Color(44, 86, 96);
    private static final Color LAUNCHER_TITLE_BACKGROUND = new Color(236, 250, 252);
    private static final Color LAUNCHER_TITLE_BORDER = new Color(70, 132, 145);
    private static final Color LAUNCHER_TITLE_TEXT = new Color(24, 75, 90);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;
    private static final String CHRISTMAS_SHAKEDOWN_COVER_ART = "assets/images/games/christmas_shakedown/cover_art/cover_art.png";
    private static final String PROJECT_CHRISTMAS_COVER_ART = "assets/images/games/project_christmas/cover_art/cover_art.png";
    private static final String CHRISTMAS_SHAKEDOWN_EXECUTABLE = "Games\\ChristmasShakedown\\Christmas Shakedown The Grinch who Hooked a Who.exe";
    private static final String PROJECT_CHRISTMAS_EXECUTABLE = "Games\\ProjectSanta\\Project Santa.exe";
    private static final int COVER_ART_X = 170;
    private static final int COVER_ART_Y = 100;
    private static final int COVER_ART_WIDTH = 280;
    private static final int COVER_ART_HEIGHT = 320;
    private static final int COVER_ART_TITLE_Y = 430;
    private static final int COVER_ART_TITLE_HEIGHT = 60;
    private static final int MAIN_MENU_SELECTION_WIDTH = 240;
    private static final int MAIN_MENU_SELECTION_HEIGHT = 275;
    private static final int MAIN_MENU_SELECTION_Y = 185;
    private static final int MAIN_MENU_LEFT_SELECTION_X = 265;
    private static final int MAIN_MENU_RIGHT_SELECTION_X = 625;
    private static final int MAIN_MENU_TITLE_Y = 470;
    private static final int MAIN_MENU_TITLE_HEIGHT = 40;
    private static final int LAUNCHER_TITLE_X = 260;
    private static final int LAUNCHER_TITLE_Y = 35;
    private static final int LAUNCHER_TITLE_WIDTH = 760;
    private static final int LAUNCHER_TITLE_HEIGHT = 95;
    private static final int PLAY_BUTTON_X = 210;
    private static final int PLAY_BUTTON_Y = 520;

    private JFrame game;

    public void Start(){
        //this is an example of how you would get an image into it, then you just cast it into the create bit of the button
        //startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        //ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
        game = new JFrame("Honker Launcher");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(1280,760);
        game.setLocation(200,100);
        game.getContentPane().setBackground(APP_BACKGROUND_COLOR);
        game.setVisible(true);
        game.setFocusable(true);
        game.setLayout(null);
        CreateMainMenu();
    }

    public void CreateGrinchMenu(){
        MakeButton(200, 100, PLAY_BUTTON_X, PLAY_BUTTON_Y, "Play", "PLAY_GRINCH");
        MakeImageLabel(COVER_ART_WIDTH,COVER_ART_HEIGHT,COVER_ART_X,COVER_ART_Y,CHRISTMAS_SHAKEDOWN_COVER_ART,"Christmas Shakedown Cover Art");
        MakeGameTitleLabel(COVER_ART_WIDTH,COVER_ART_TITLE_HEIGHT,COVER_ART_X,COVER_ART_TITLE_Y,"Christmas Shakedown", 24f);
        MakeDescriptionLabel(600,210,500,150,"Grinch Game Discription");
        MakeButton(100,50,1000,550,"Back", "BACK");
        game.revalidate();
        game.repaint();
    }

    public void CreateProjectChristmasMenu(){
        MakeButton(200, 100, PLAY_BUTTON_X, PLAY_BUTTON_Y, "Play", "PLAY_CHRISTMAS");
        MakeImageLabel(COVER_ART_WIDTH,COVER_ART_HEIGHT,COVER_ART_X,COVER_ART_Y,PROJECT_CHRISTMAS_COVER_ART,"Project Christmas Cover Art");
        MakeGameTitleLabel(COVER_ART_WIDTH,COVER_ART_TITLE_HEIGHT,COVER_ART_X,COVER_ART_TITLE_Y,"Project Christmas", 24f);
        MakeDescriptionLabel(600,210,500,150,"Project Christmas Game Discription");
        MakeButton(100,50,1000,550,"Back", "BACK");
        game.revalidate();
        game.repaint();
    }

    public void WipeScene(){
        Component[] components = game.getContentPane().getComponents();
        for(Component component : components){
            component.setVisible(false);
        }
        game.revalidate();
        game.repaint();
        System.out.println("Scene Wiped");
    }

    public void CreateMainMenu(){
        MakeLauncherTitleSection(LAUNCHER_TITLE_WIDTH, LAUNCHER_TITLE_HEIGHT, LAUNCHER_TITLE_X, LAUNCHER_TITLE_Y, "Honker Launcher");
        MakeSelectionButton(MAIN_MENU_SELECTION_WIDTH, MAIN_MENU_SELECTION_HEIGHT, MAIN_MENU_LEFT_SELECTION_X, MAIN_MENU_SELECTION_Y, PROJECT_CHRISTMAS_COVER_ART, "Project Christmas", "OPEN_PROJECT_CHRISTMAS");
        MakeSelectionButton(MAIN_MENU_SELECTION_WIDTH, MAIN_MENU_SELECTION_HEIGHT, MAIN_MENU_RIGHT_SELECTION_X, MAIN_MENU_SELECTION_Y, CHRISTMAS_SHAKEDOWN_COVER_ART, "Christmas Shakedown", "OPEN_GRINCH");
        MakeGameTitleLabel(MAIN_MENU_SELECTION_WIDTH, MAIN_MENU_TITLE_HEIGHT, MAIN_MENU_LEFT_SELECTION_X, MAIN_MENU_TITLE_Y, "Project Christmas", 21f);
        MakeGameTitleLabel(MAIN_MENU_SELECTION_WIDTH, MAIN_MENU_TITLE_HEIGHT, MAIN_MENU_RIGHT_SELECTION_X, MAIN_MENU_TITLE_Y, "Christmas Shakedown", 21f);
        MakeButton(100,50,580,550,"Exit", "EXIT");
        //MakeLabel(1280,760,0,0,Color.DARK_GRAY,"");
        game.revalidate();
        game.repaint();
    }

    //youll have to add a image into here when you make it
    public void MakeButton(int width, int height, int x, int y, String text){
        MakeButton(width, height, x, y, text, text);
    }

    public void MakeButton(int width, int height, int x, int y, String text, String actionCommand){
        JButton button = createStyledButton(text);
        button.setBounds(x,y,width,height);
        button.setVisible(true);
        button.setText(text);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        game.add(button);
    }

    public void MakeSelectionButton(int width, int height, int x, int y, String imagePath, String fallbackText, String actionCommand){
        JButton button = new ImageButton(imagePath, fallbackText, 42, 5);
        button.setBounds(x,y,width,height);
        button.setVisible(true);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        game.add(button);
    }

    private JButton createStyledButton(String text){
        String normalizedText = text.toLowerCase();

        if(normalizedText.contains("play")){
            return new RoundedButton(text, PLAY_BUTTON_COLOR, PLAY_BUTTON_BORDER, 46, 5);
        }

        if(normalizedText.contains("back") || normalizedText.contains("exit")){
            return new RoundedButton(text, EXIT_BUTTON_COLOR, EXIT_BUTTON_BORDER, 28, 3);
        }

        JButton button = new JButton(text);
        button.setFocusPainted(false);
        return button;
    }

    //you can use this to place images
    public void MakeLabel(int width, int height, int x, int y, Color color, String text){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(color);
        label.setOpaque(true);
        game.add(label);
    }

    public void MakeGameTitleLabel(int width, int height, int x, int y, String text, float fontSize){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, fontSize));
        label.setForeground(TITLE_TEXT_COLOR);
        label.setBackground(TITLE_PANEL_BACKGROUND);
        label.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(TITLE_PANEL_BORDER, 2),
            javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)
        ));
        label.setOpaque(true);
        game.add(label);
    }

    public void MakeDescriptionLabel(int width, int height, int x, int y, String text){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setText("<html><div style='text-align:center; padding:12px;'>" + text + "</div></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 20f));
        label.setForeground(DESCRIPTION_TEXT_COLOR);
        label.setBackground(DESCRIPTION_PANEL_BACKGROUND);
        label.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(DESCRIPTION_PANEL_BORDER, 2),
            javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        label.setOpaque(true);
        game.add(label);
    }

    public void MakeLauncherTitleSection(int width, int height, int x, int y, String text){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 38f));
        label.setForeground(LAUNCHER_TITLE_TEXT);
        label.setBackground(LAUNCHER_TITLE_BACKGROUND);
        label.setBorder(javax.swing.BorderFactory.createLineBorder(LAUNCHER_TITLE_BORDER, 3));
        label.setOpaque(true);
        game.add(label);
    }

    public void MakeImageLabel(int width, int height, int x, int y, String imagePath, String fallbackText){
        JLabel label = new JLabel();
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        label.setOpaque(true);

        File imageFile = new File(imagePath);
        if(imageFile.exists()){
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        }else{
            label.setText(fallbackText);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBackground(Color.lightGray);
        }

        game.add(label);
    }

    private void launchGame(String executablePath){
        File executable = new File(executablePath);
        if(!executable.exists()){
            System.err.println("Game executable not found: " + executable.getAbsolutePath());
            return;
        }

        ProcessBuilder gameProcess = new ProcessBuilder(executable.getPath());
        try{
            gameProcess.start();
        }catch(IOException ex){
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if(event.equals("OPEN_GRINCH")){
            System.out.println("Christmas Shakedown Button Pressed");
            WipeScene();
            CreateGrinchMenu();
        }else if(event.equals("OPEN_PROJECT_CHRISTMAS")){
            System.out.println("Project Christmas Button Pressed");
            WipeScene();
            CreateProjectChristmasMenu();
        }else if(event.equals("PLAY_GRINCH")){
            launchGame(CHRISTMAS_SHAKEDOWN_EXECUTABLE);
        }else if(event.equals("PLAY_CHRISTMAS")){
            launchGame(PROJECT_CHRISTMAS_EXECUTABLE);
        }else if(event.equals("BACK")){
            WipeScene();
            CreateMainMenu();
        }else if(event.equals("EXIT")){
            System.exit(0);
        }
    }

    private static class ImageButton extends JButton{
        private final Image image;
        private final int arcSize;
        private final int borderThickness;
        private Shape shape;

        ImageButton(String imagePath, String fallbackText, int arcSize, int borderThickness){
            super(new File(imagePath).exists() ? "" : fallbackText);
            this.image = new File(imagePath).exists() ? new ImageIcon(imagePath).getImage() : null;
            this.arcSize = arcSize;
            this.borderThickness = borderThickness;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            setForeground(Color.BLACK);
            setFont(getFont().deriveFont(Font.BOLD, 20f));
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        protected void paintComponent(Graphics graphics){
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape clip = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
            g2.setClip(clip);

            if(image != null){
                g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                if(getModel().isArmed()){
                    g2.setColor(new Color(0, 0, 0, 60));
                    g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
                }
            }else{
                g2.setColor(SELECTION_BUTTON_FALLBACK);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
            }

            g2.dispose();
            super.paintComponent(graphics);
        }

        @Override
        protected void paintBorder(Graphics graphics){
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(SELECTION_BUTTON_BORDER);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.drawRoundRect(borderThickness / 2, borderThickness / 2, getWidth() - borderThickness, getHeight() - borderThickness, arcSize, arcSize);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y){
            if(shape == null || !shape.getBounds().equals(getBounds())){
                shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcSize, arcSize);
            }

            return shape.contains(x, y);
        }
    }

    private static class RoundedButton extends JButton{
        private final Color fillColor;
        private final Color borderColor;
        private final int arcSize;
        private final int borderThickness;
        private Shape shape;

        RoundedButton(String text, Color fillColor, Color borderColor, int arcSize, int borderThickness){
            super(text);
            this.fillColor = fillColor;
            this.borderColor = borderColor;
            this.arcSize = arcSize;
            this.borderThickness = borderThickness;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            setForeground(BUTTON_TEXT_COLOR);
            setFont(getFont().deriveFont(Font.BOLD, 20f));
        }

        @Override
        protected void paintComponent(Graphics graphics){
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getModel().isArmed() ? fillColor.darker() : fillColor);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics graphics){
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.drawRoundRect(borderThickness / 2, borderThickness / 2, getWidth() - borderThickness, getHeight() - borderThickness, arcSize, arcSize);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y){
            if(shape == null || !shape.getBounds().equals(getBounds())){
                shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcSize, arcSize);
            }

            return shape.contains(x, y);
        }
    }
}