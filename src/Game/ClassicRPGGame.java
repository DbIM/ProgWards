package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClassicRPGGame implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    JLabel backgroundLabel;
    BufferedImage playerArrowImage;
    JLabel playerArrowLabel;
    String wherePlayerLook = "";

    int counter = 0;

    public ClassicRPGGame() throws IOException {
        frame = new JFrame("Classic RPG");
        frame.setSize(1024,640);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        ActionListener bowButtonActionListener = new bowButtonActionListener();
        ActionListener exitButtonActionListener = new exitButtonActionListener();
        ActionListener upLeftButtonActionListener = new upLeftButtonActionListener();
        ActionListener upRightButtonActionListener = new upRightButtonActionListener();

        BufferedImage bowButtonIcon = ImageIO.read(new File("src/Game/img/buttons/bowbutton.JPG"));
        JButton bowButton = new JButton(new ImageIcon(bowButtonIcon));
        bowButton.setBorder(BorderFactory.createEmptyBorder());
        bowButton.setFocusPainted(false);
        bowButton.setContentAreaFilled(false);
        bowButton.setBounds(740,230,97,82);
        bowButton.addActionListener(bowButtonActionListener);
        panel.add(bowButton);

        BufferedImage exitButtonIcon = ImageIO.read(new File("src/Game/img/buttons/exit.JPG"));
        JButton exitButton = new JButton(new ImageIcon(exitButtonIcon));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBounds(826,305,86,70);
        exitButton.addActionListener(exitButtonActionListener);
        panel.add(exitButton);

        BufferedImage upleftbuttonicon = ImageIO.read(new File("src/Game/img/buttons/upleft.JPG"));
        JButton upleftbutton = new JButton(new ImageIcon(upleftbuttonicon));
        upleftbutton.setBorder(BorderFactory.createEmptyBorder());
        upleftbutton.setFocusPainted(false);
        upleftbutton.setContentAreaFilled(false);
        upleftbutton.setBounds(750,470,79,65);
        upleftbutton.addActionListener(upLeftButtonActionListener);
        panel.add(upleftbutton);

        BufferedImage upbuttonicon = ImageIO.read(new File("src/Game/img/buttons/up.JPG"));
        JButton upbutton = new JButton(new ImageIcon(upbuttonicon));
        upbutton.setBorder(BorderFactory.createEmptyBorder());
        upbutton.setFocusPainted(false);
        upbutton.setContentAreaFilled(false);
        upbutton.setBounds(825,470,88,71);
        upbutton.addActionListener(this);
        panel.add(upbutton);

        BufferedImage uprightbuttonicon = ImageIO.read(new File("src/Game/img/buttons/upright.JPG"));
        JButton uprightbutton = new JButton(new ImageIcon(uprightbuttonicon));
        uprightbutton.setBorder(BorderFactory.createEmptyBorder());
        uprightbutton.setFocusPainted(false);
        uprightbutton.setContentAreaFilled(false);
        uprightbutton.setBounds(910,470,82,70);
        uprightbutton.addActionListener(upRightButtonActionListener);
        panel.add(uprightbutton);

        BufferedImage leftbuttonicon = ImageIO.read(new File("src/Game/img/buttons/left.JPG"));
        JButton leftbutton = new JButton(new ImageIcon(leftbuttonicon));
        leftbutton.setBorder(BorderFactory.createEmptyBorder());
        leftbutton.setFocusPainted(false);
        leftbutton.setContentAreaFilled(false);
        leftbutton.setBounds(746,538,83,67);
        leftbutton.addActionListener(this);
        panel.add(leftbutton);

        BufferedImage downbuttonicon = ImageIO.read(new File("src/Game/img/buttons/down.JPG"));
        JButton downbutton = new JButton(new ImageIcon(downbuttonicon));
        downbutton.setBorder(BorderFactory.createEmptyBorder());
        downbutton.setFocusPainted(false);
        downbutton.setContentAreaFilled(false);
        downbutton.setBounds(828,538,82,68);
        downbutton.addActionListener(this);
        panel.add(downbutton);

        BufferedImage rightbuttonicon = ImageIO.read(new File("src/Game/img/buttons/right.JPG"));
        JButton rightbutton = new JButton(new ImageIcon(rightbuttonicon));
        rightbutton.setBorder(BorderFactory.createEmptyBorder());
        rightbutton.setFocusPainted(false);
        rightbutton.setContentAreaFilled(false);
        rightbutton.setBounds(910,538,82,68);
        rightbutton.addActionListener(this);
        panel.add(rightbutton);

        playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.JPG"));
        wherePlayerLook = "south";
        playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
        playerArrowLabel.setBounds(856,112,32,28);
        panel.add(playerArrowLabel);

        BufferedImage backgroundImage = ImageIO.read(new File("src/Game/img/Newcastle.png"));
        backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0,0,1024,640);
        panel.add(backgroundLabel);

        frame.setVisible(true);
    }

    public class upLeftButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if (wherePlayerLook.equals("south")){
               try {
                   panel.remove(playerArrowLabel);
                   panel.remove(backgroundLabel);
                   playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow2.JPG"));
                   playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                   playerArrowLabel.setBounds(856,112,32,28);
                   panel.add(playerArrowLabel);
                   panel.add(backgroundLabel);
                   panel.updateUI();
                   wherePlayerLook = "east";
                   System.out.println("Player look: " + wherePlayerLook);
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
           }
           else if (wherePlayerLook.equals("east")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow3.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "north";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
           else if (wherePlayerLook.equals("north")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow4.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "west";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (wherePlayerLook.equals("west")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "south";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public class upRightButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (wherePlayerLook.equals("south")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow4.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "west";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (wherePlayerLook.equals("west")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow3.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "north";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (wherePlayerLook.equals("north")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow2.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "east";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (wherePlayerLook.equals("east")){
                try {
                    panel.remove(playerArrowLabel);
                    panel.remove(backgroundLabel);
                    panel.updateUI();
                    playerArrowImage = ImageIO.read(new File("src/Game/img/playerArrow/playerArrow1.JPG"));
                    playerArrowLabel = new JLabel(new ImageIcon(playerArrowImage));
                    playerArrowLabel.setBounds(856,112,32,28);
                    panel.add(playerArrowLabel);
                    panel.add(backgroundLabel);
                    panel.updateUI();
                    wherePlayerLook = "south";
                    System.out.println("Player look: " + wherePlayerLook);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public class bowButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Bow button pressed");
        }
    }

    public class exitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println("Button clicked " + counter + " time");
    }
}
