package views;

import controllers.game.BackToMenuShortCut;
import views.game.Game;
import views.menu.MenuStart;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PACMANGame extends JFrame {

    public static final String MENU_VIEW = "0";
    public static final String GAME_VIEW = "1";
    public String currentCardName = MENU_VIEW;
    public static ViewCardPanel viewsCardPanel;
    public static MenuStart menuStart;
    public static Game game;

    public static int screenWidth;
    public static int screenHeight;
    public static Dimension screenSize;
    public Font Butterbelly;

    public PACMANGame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.screenSize = toolkit.getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setMinimumSize(new Dimension(1480, 820));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PACMAN GAME");
        this.setFont(Butterbelly);

        this.setLayout(new BorderLayout());

        Container contentPane = getContentPane();

        //==================================================================================

        String fontPath = "Butterbelly.otf";
        try {
            Font customFont = Font.createFont(Font.PLAIN, new File(fontPath));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            customFont = customFont.deriveFont(Font.PLAIN, 24);
            this.Butterbelly = customFont;

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //===================================================================================

        this.viewsCardPanel = new ViewCardPanel();

        game = new Game(this);
        menuStart = new MenuStart(this, game);

        viewsCardPanel.add(menuStart, MENU_VIEW);
        viewsCardPanel.add(game, GAME_VIEW);

        contentPane.add(viewsCardPanel);

        //===================================================================================

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new BackToMenuShortCut(this));

        this.setVisible(true);


    }
}