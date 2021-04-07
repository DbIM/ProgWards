package Game;

import javax.swing.*;
import java.io.IOException;

public class CastleFrame {
    private static JFrame frame;
    private static JPanel panel;
    JLabel eyeView;

    public CastleFrame() throws IOException {
        frame = new JFrame("Inside the Castle");
        frame.setSize(720, 421);
        frame.setUndecorated(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        eyeView = new JLabel(new ImageIcon("src/Game/img/scroll1.png"));
        eyeView.setBounds(455, 0, 260, 491);
        panel.add(eyeView);
        eyeView = new JLabel(new ImageIcon("src/Game/img/lady.png"));
        eyeView.setBounds(0, 0, 720, 421);
        panel.add(eyeView);
        frame.setVisible(true);
    }
}
