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
    int counter = 0;

    public ClassicRPGGame() throws IOException {
        frame = new JFrame("Classic RPG");
        frame.setSize(1038,678);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        BufferedImage buttonIcon = ImageIO.read(new File("src/Game/img/bowbutton2.JPG"));
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBounds(740,230,97,82);
        button.addActionListener(this);
        panel.add(button);

        BufferedImage backgroundImage = ImageIO.read(new File("src/Game/img/Newcastle.png"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0,0,1024,640);
        panel.add(backgroundLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new ClassicRPGGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println("Button clicked " + counter + " time");
    }
}
