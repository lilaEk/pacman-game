package views.menu.components.middlePanels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JPanel {

    public NewGame(int width, int height, PACMANGame pacmanGameFrame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BoxLayout(this, 0));

        CustomizeYourGame customizeYourGame = new CustomizeYourGame(pacmanGameFrame, (int) (width * 0.6), height);
        Rules rules = new Rules(pacmanGameFrame, (int) (width * 0.4), height);

        this.add(customizeYourGame);
        this.add(rules);
    }
}

class CustomizeYourGame extends JPanel {

    private String text;
    public JButton play;
    public Color pink = new Color(0xFD66C3);
    private String windowGameSize = "SET WINDOW GAME SIZE";
    private int width;
    private int height;
    private String yourNick = "SET YOUR NICKNAME";

    public CustomizeYourGame(PACMANGame pacmanGame, int width, int height) {

        Font font1 = new Font("Butterbelly", Font.PLAIN, 50);
        Font font2 = new Font("Butterbelly", Font.PLAIN, 16);

        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        //------------------------------------------ wiersz 0
        JTextArea rows = new JTextArea("rows");
        rows.setForeground(Color.WHITE);
        rows.setBackground(Color.BLACK);
        rows.setFont(font2);
        rows.setEnabled(false);
        rows.setEditable(false);

        JTextArea columns = new JTextArea("columns");
        columns.setForeground(Color.WHITE);
        columns.setBackground(Color.BLACK);
        columns.setFont(font2);
        columns.setEnabled(false);
        columns.setEditable(false);

        //------------------------------------------ wiersz 1
        JTextArea windowGameSize = new JTextArea(this.windowGameSize);
        windowGameSize.setForeground(Color.WHITE);
        windowGameSize.setBackground(Color.BLACK);
        windowGameSize.setFont(font1);
        windowGameSize.setEnabled(false);
        windowGameSize.setEditable(false);

        JTextField setWindowsSize1 = new JTextField();
        JTextField setWindowsSize2 = new JTextField();

        int size = 80;
        setWindowsSize1.setPreferredSize(new Dimension(size, size));
        setWindowsSize1.setMaximumSize(new Dimension(size, size));

        setWindowsSize2.setPreferredSize(new Dimension(size, size));
        setWindowsSize2.setMaximumSize(new Dimension(size, size));

        //------------------------------------------ wiersz 2
        JTextArea yourNick = new JTextArea(this.yourNick);
        yourNick.setForeground(Color.WHITE);
        yourNick.setBackground(Color.BLACK);
        yourNick.setFont(font1);
        yourNick.setEnabled(false);
        yourNick.setEditable(false);

        JTextField setYourNick = new JTextField();
        setYourNick.setPreferredSize(new Dimension(150, 60));

        //------------------------------------------ wiersz 3
        this.play = new JButton("play!");
        play.setBackground(this.pink);
        play.setFont(pacmanGame.Butterbelly);
        play.setForeground(Color.BLACK);
//        play.setSize(new Dimension(300, 80));

        //------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 40);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(rows, gbc);
        gbc.gridx = 0;

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(columns, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 40);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(windowGameSize, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 30);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowsSize1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowsSize2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 20, 30);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(yourNick, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(20, 0, 20, 0);
        this.add(setYourNick, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.ipady = 40;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(40, 0, 0, 0);
        this.add(play, gbc);

    }
}

class Rules extends JPanel {

    private String rules = "RULES";
    private String text1, text2, text3, text4, text5;
    private Color c1 = new Color(0xE9FDAE);
    private Color c2 = new Color(0xFDA8F7);
    private int width;
    private int height;
    private PACMANGame pacmanGame;

    public Rules(PACMANGame pacmanGame, int width, int height) {

        this.pacmanGame = pacmanGame;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        this.text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae\n";
        this.text2 = "efficitur ligula, in viverra ipsum. Orci varius natoque penatibus\n";
        this.text3 = "et magnis dis parturient montes, nascetur ridiculus mus. Etiam eu\n";
        this.text4 = "molestie dolor. Vestibulum placerat metus vitae justo rutrum mollis.\n";
        this.text5 = "Nam blandit rhoncus neque molestie vulputate.";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 60, this.c1, getWidth() - 80, getHeight() - 120, c2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 60, getWidth() - 80, getHeight() - 120);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);

        Font f1 = new Font("Butterbelly", Font.PLAIN, 24);
        g2d.setFont(f1);
        g2d.drawString(this.rules, 50, (getHeight() / 5) + 30);

        Font f2 = new Font("Arimo", Font.PLAIN, 14);
        g2d.setFont(f2);
        g2d.drawString(this.text1, 50, (getHeight() / 5) + 60);
        g2d.drawString(this.text2, 50, (getHeight() / 5) + 60 + 16);
        g2d.drawString(this.text3, 50, (getHeight() / 5) + 60 + 32);
        g2d.drawString(this.text4, 50, (getHeight() / 5) + 60 + 48);
        g2d.drawString(this.text5, 50, (getHeight() / 5) + 60 + 64);
    }
}