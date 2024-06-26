package controllers.menu;

import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.Game;
import views.game.components.GameCardPanel;
import views.game.components.StartGameViewChange;
import views.game.components.panels.GameWindow;
import views.menu.components.middlePanels.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayButtonMouseListener implements MouseListener {

    private final JButton play;
    private final PACMANGame pacmanGame;
    private final NewGame newGame;
    private final Game game;
    public static final Object monitor = new Object();


    public PlayButtonMouseListener(NewGame newGame, PACMANGame pacmanGame, Game game) {
        this.pacmanGame = pacmanGame;
        this.newGame = newGame;
        this.game = game;

        this.play = newGame.play;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.play) {

            if (!NewGame.isValue1Valid || !NewGame.isValue2Valid) {
                NewGame.warningField.setText(NewGame.warningFieldIsNotCorrectSize);
                if (NewGame.isNickValid) {
                    NewGame.warningNick.setText(NewGame.warningFieldIsNotCorrectSizeDefaut);
                }
            }
            if (!NewGame.isNickValid) {
                NewGame.warningNick.setText(NewGame.warningYourNickExists);
                if (NewGame.isValue1Valid && NewGame.isValue2Valid) {
                    NewGame.warningField.setText(NewGame.warningYourNickExistsDefault);
                }
            }

            if (NewGame.isValue1Valid && NewGame.isValue2Valid && NewGame.isNickValid) {

                NewGame.warningField.setText(NewGame.warningFieldIsNotCorrectSizeDefaut);
                NewGame.warningNick.setText(NewGame.warningYourNickExistsDefault);

                Game.gameWindow = new GameWindow(PACMANGame.screenWidth, PACMANGame.screenHeight, pacmanGame, NewGame.setRows, NewGame.setColumns);
                game.gameCardPanel.add(Game.gameWindow, GameCardPanel.GAME_WINDOW);
                CardLayout cl1 = (CardLayout) (game.gameCardPanel.getLayout());
                cl1.show(game.gameCardPanel, GameCardPanel.currentCardName);

                //===============================================================================

                CardLayout cl = (CardLayout) (PACMANGame.viewsCardPanel.getLayout());
                cl.show(PACMANGame.viewsCardPanel, ViewCardPanel.GAME_VIEW);
                PACMANGame.viewsCardPanel.currentCardName = ViewCardPanel.GAME_VIEW;

                //===============================================================================

                StartGameViewChange startGameViewChange = new StartGameViewChange(game, pacmanGame);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.play) {
            newGame.play.setBackground(GameColors.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.play) {
            newGame.play.setBackground(GameColors.pink);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
