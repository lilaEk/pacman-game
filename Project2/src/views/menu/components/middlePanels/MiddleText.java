package views.menu.components.middlePanels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class MiddleText extends JPanel {

    public MiddleText(int width, int height, PACMANGame pacmanGame) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());

        String text = "<html><center>The classic and enormously popular Pac-Manvideo game came out<br>" +
                "in Japan on May 21, 1980, and by October of that year it was released<br>" +
                " in the United States. The yellow, pie-shaped Pac-Man character,<br>" +
                "who travels around a maze trying to eat dots and avoid four hunting ghosts,<br>" +
                "quickly became an icon of the 1980s." +
                "</center></html>";

        JLabel textLabel = new JLabel(text);

        textLabel.setForeground(Color.ORANGE); // przy formatowaniu html, metoda ta nie ma wpływu na resztę
        textLabel.setBackground(Color.BLACK);
        textLabel.setFont(pacmanGame.Butterbelly);

        textLabel.setEnabled(false);

        this.add(textLabel);
    }

}
