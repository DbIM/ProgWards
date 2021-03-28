package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPG implements ActionListener {

    int count = 0;
    private JLabel label;
    private JFrame frame;
    private JButton button;
    private JPanel panel;

    public RPG(){
        frame = new JFrame();
        frame.setSize(640, 480);

        button = new JButton("First button");
        button.addActionListener(this);
        button.setLocation(100, 250);
        label = new JLabel("Number of click's: 0");
        label.setLocation(100,250);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 200, 300, 250));
        panel.setLayout(new GridLayout(1, 0));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RPG();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of click's: " + count);

    }
}


//https://beginnersbook.com/2015/07/java-swing-tutorial/