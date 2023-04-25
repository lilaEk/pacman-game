package views.menu.components.upperPanels;

import controllers.menu.MenuButtonsMouseListener;
import views.PACMANGame;
import views.menu.MenuStart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Buttons extends JPanel {

    public JButton new_game;
    public JButton high_scores;
    public JButton exit_game;
    public Color pink = new Color(0xFD66C3);
    public Color blue = new Color(0x00FDFE);


    public Buttons(int width, int height, MenuStart menuStart, PACMANGame pacmanGameFrame) {

        //==============================================================================

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(1, 3, 40, 20);
        this.setLayout(layout);

        //================================================================================

        this.new_game = new JButton("new game");
        this.high_scores = new JButton("HIgH scores");
        this.exit_game = new JButton("exIT");

        ArrayList<JButton> menuButtons = new ArrayList<>();
        menuButtons.add(new_game);
        menuButtons.add(high_scores);
        menuButtons.add(exit_game);

        for (JButton b : menuButtons) {
            b.setBackground(pink);
            b.setFont(pacmanGameFrame.Butterbelly);
            b.setForeground(Color.BLACK);
            this.add(b);
        }

        //===============================================================================

        MenuButtonsMouseListener menuButtonsMouseListener = new MenuButtonsMouseListener(this, menuStart);

    }

    public JButton getNew_game() {
        return new_game;
    }

    public JButton getHigh_scores() {
        return high_scores;
    }

    public JButton getExit_game() {
        return exit_game;
    }

}
