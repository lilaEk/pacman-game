package views.menu.components.middlePanels;

import controllers.menu.PlayButtonMouseListener;
import views.GameColors;
import views.PACMANGame;
import views.game.Game;
import views.menu.MenuStart;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class NewGame extends JPanel {

    private String text = "<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae<br>" +
            "efficitur ligula, in viverra ipsum. Orci varius natoque penatibus et magnis dis<br>" +
            "parturient montes, nascetur ridiculus mus. Etiam eu molestie dolor.<br>" +
            "Vestibulum placerat metus vitae justo rutrum mollis. Nam blandit<br>" +
            "rhoncus neque molestie vulputate.</html>";
    public JButton play;
    private String windowGameSize = "SET GAME SIZE";
    private int width;
    private int height;
    private String yourNick = "SET NICKNAME";

    public static final String warningFieldIsNotCorrectSize = "<html><font color=#A60909>Please set the size between 10x10 and 100x100.</font></html>";
    public static final String warningYourNickExists = "<html><font color=#A60909>Nick is blank or already exists. Please choose new nick.</font></html>";

    public static final String warningFieldIsNotCorrectSizeDefaut = "<html><font color=black>Please set the size between 10x10 and 100x100.</font></html>";
    public static final String warningYourNickExistsDefault = "<html><font color=black>Nick is blank or already exists. Please choose new nick.</font></html>";

    public static JLabel warningField;
    public static JLabel warningNick;

    public static boolean isValue1Valid = false;
    public static boolean isValue2Valid = false;
    public static boolean isNickValid = false;

    public static int setRows;
    public static int setColumns;
    public static String setYourNick;
    public static JTextField setWindowSize1;
    public static JTextField setWindowSize2;
    public static JTextField setYourNickField;

    public NewGame(int width, int height, PACMANGame pacmanGame, MenuStart menuStart, Game game) {

        Font font1 = new Font("Butterbelly", Font.PLAIN, 50);
        Font font2 = new Font("Butterbelly", Font.PLAIN, 16);

        this.width = width;
        this.height = height;

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        //------------------------------------------ wiersz 0
        JTextArea rows = new JTextArea("rows   ");
        rows.setFocusable(false);
        rows.setForeground(Color.WHITE);
        rows.setBackground(Color.BLACK);
        rows.setFont(font2);
        rows.setEditable(false);

        JTextArea columns = new JTextArea("columns");
        columns.setFocusable(false);
        columns.setForeground(Color.WHITE);
        columns.setBackground(Color.BLACK);
        columns.setFont(font2);
        columns.setEditable(false);

        GradientText gradientText = new GradientText();

        //------------------------------------------ wiersz 2
        warningField = new JLabel(warningFieldIsNotCorrectSizeDefaut);

        //------------------------------------------ wiersz 1
        JTextArea windowGameSize = new JTextArea(this.windowGameSize);
        windowGameSize.setForeground(Color.WHITE);
        windowGameSize.setBackground(Color.BLACK);
        windowGameSize.setFont(font1);
        windowGameSize.setEditable(false);

        setWindowSize1 = new JTextField();
        setWindowSize2 = new JTextField();

        int size = 80;
        setWindowSize1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateValue();
            }

            public void removeUpdate(DocumentEvent e) {
                updateValue();
            }

            public void changedUpdate(DocumentEvent e) {
                updateValue();
            }

            private void updateValue() {
                String text = setWindowSize1.getText();
                if (text.matches("\\d+") && Integer.parseInt(text) >= 10 && Integer.parseInt(text) <= 100) {
                    setRows = Integer.parseInt(text);
                    isValue1Valid = true;
                } else {
                    isValue1Valid = false;
                }
            }
        });

        setWindowSize2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateButton();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButton();
            }

            public void changedUpdate(DocumentEvent e) {
                updateButton();
            }

            private void updateButton() {
                String text = setWindowSize2.getText();
                if (text.matches("\\d+") && Integer.parseInt(text) >= 10 && Integer.parseInt(text) <= 100) {
                    isValue2Valid = true;
                    setColumns = Integer.parseInt(text);
                } else {
                    isValue2Valid = false;
                }
            }
        });
        //------------------------------------------ wiersz 4
        warningNick = new JLabel(warningYourNickExistsDefault);

        //------------------------------------------ wiersz 3
        JTextArea yourNick = new JTextArea(this.yourNick);
        yourNick.setFocusable(false);
        yourNick.setForeground(Color.WHITE);
        yourNick.setBackground(Color.BLACK);
        yourNick.setFont(font1);
        yourNick.setEditable(false);

        setYourNickField = new JTextField();

        setYourNickField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateButton();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButton();
            }

            public void changedUpdate(DocumentEvent e) {
                updateButton();
            }

            private void updateButton() {
                setYourNick = setYourNickField.getText();
                if (text != null) {
                    isNickValid = true;
                } else {
                    isNickValid = false;
                }
            }
        });

        //------------------------------------------ wiersz 5
        this.play = new JButton("play!");
        play.setBackground(GameColors.pink);
        play.setFont(pacmanGame.Butterbelly);
        play.setForeground(Color.BLACK);

        //-------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 40);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(rows, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(columns, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 40);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(windowGameSize, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 30);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowSize1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowSize2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 30;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(warningField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 30);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(yourNick, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 0, 0, 0);
        this.add(setYourNickField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 30;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(warningNick, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 30;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(play, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 80, 20, 0);
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 500;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        this.add(gradientText, gbc);

        this.play.addMouseListener(new PlayButtonMouseListener(this, pacmanGame, game));
        this.play.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
    }
}


class GradientText extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String rules = "RULES";
        String text1 = "The player controls Pac-Man, who must eat all\n";
        String text2 = "the dots inside an enclosed maze while avoiding\n";
        String text3 = "four colored ghosts. Eating large flashing dots\n";
        String text4 = "called \"Power Pellets\" causes the ghosts to\n";
        String text5 = "temporarily turn blue, allowing Pac-Man to eat\n";
        String text6 = "them for bonus points.\n";
        String textBreak = "\n";
        String text7 = "WIKIPEDIA";

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, GameColors.gradient1, getWidth() / 2, getHeight(), GameColors.gradient2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 550, getHeight());

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);

        Font f1 = new Font("Butterbelly", Font.PLAIN, 24);
        g2d.setFont(f1);
        g2d.drawString(rules, 50, (getHeight() / 5) + 30);

        Font f2 = new Font("Consolas", Font.PLAIN, 14);
        g2d.setFont(f2);
        g2d.drawString(text1, 50, (getHeight() / 5) + 60 + 16);
        g2d.drawString(text2, 50, (getHeight() / 5) + 60 + 32);
        g2d.drawString(text3, 50, (getHeight() / 5) + 60 + 48);
        g2d.drawString(text4, 50, (getHeight() / 5) + 60 + 64);
        g2d.drawString(text5, 50, (getHeight() / 5) + 60 + 80);
        g2d.drawString(text6, 50, (getHeight() / 5) + +60 + 96);
        g2d.drawString(textBreak, 50, (getHeight() / 5) + 60 + 112);
        g2d.drawString(text7, 50, (getHeight() / 5) + 60 + 128);
    }

}