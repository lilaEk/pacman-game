package controllers.game;

import model.characters.Player;
import model.characters.components.Destination;
import model.game.Bonuses;
import model.game.GameThread;
import model.map.MapModel;
import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.CurrentStats;
import views.menu.MenuStart;
import views.menu.components.MenuCardPanel;
import views.menu.components.upperPanels.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static model.map.MapModel.cookiesCounter;
import static model.map.MapModel.player;

public class PacKeyMovement implements KeyListener {

    JTable table;
    MapModel mapModel;
    PACMANGame pacmanGame;

    public PacKeyMovement(JTable table, MapModel mapModel, PACMANGame pacmanGame) {
        this.table = table;
        this.mapModel = mapModel;
        this.pacmanGame = pacmanGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            if (CurrentStats.timeThread == null) return;
            System.out.println("Pressed Ctrl + Shift + Q");

            cookiesCounter = 0;
            GameThread.isReady.set(false);
            GameThread.isGameViewReady.set(false);

            CardLayout cl = (CardLayout) (PACMANGame.viewsCardPanel.getLayout());
            PACMANGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;
            cl.show(PACMANGame.viewsCardPanel, PACMANGame.viewsCardPanel.currentCardName);

            CardLayout cl2 = (CardLayout) (MenuStart.cardsPanel.getLayout());
            MenuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
            Buttons.new_game.setBackground(GameColors.pink);
            Buttons.high_scores.setBackground(GameColors.pink);
            cl2.show(MenuStart.cardsPanel, MenuCardPanel.TEXT);

            GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;

            Player.numberOfBonusesOnMap = 0;
            CurrentStats.livesNumber = 5;
            CurrentStats.yourScore = 0;
            return;
        }

        if (player.bonusState == Bonuses.LEAF) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                    player.destination = Destination.UP;
                    player.moveHorizontally(player.getCurrentRow() - 1);
                }

                case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                    player.destination = Destination.LEFT;
                    if (player.getCurrentColumn() - 1 < 0) {
                        player.moveVertically(mapModel.getColumnCount() - 1);
                        return;
                    }
                    player.moveVertically(player.getCurrentColumn() - 1);
                }

                case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                    player.destination = Destination.DOWN;
                    player.moveHorizontally(player.getCurrentRow() + 1);
                }

                case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                    player.destination = Destination.RIGHT;
                    if (player.getCurrentColumn() + 1 > mapModel.getColumnCount() - 1) {
                        player.moveVertically(0);
                        return;
                    }
                    player.moveVertically(player.getCurrentColumn() + 1);
                }
            }
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                player.destination = Destination.UP;
                player.moveHorizontally(player.getCurrentRow() - 1);
            }

            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                player.destination = Destination.LEFT;
                if (player.getCurrentColumn() - 1 < 0) {
                    player.moveVertically(mapModel.getColumnCount() - 1);
                    return;
                }
                player.moveVertically(player.getCurrentColumn() - 1);
            }

            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                player.destination = Destination.DOWN;
                player.moveHorizontally(player.getCurrentRow() + 1);
            }

            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                player.destination = Destination.RIGHT;
                if (player.getCurrentColumn() + 1 > mapModel.getColumnCount() - 1) {
                    player.moveVertically(0);
                    return;
                }
                player.moveVertically(player.getCurrentColumn() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}