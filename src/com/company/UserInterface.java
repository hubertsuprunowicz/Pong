package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class UserInterface extends JFrame {
    private Container background;

    public UserInterface(Integer width, Integer height) {
        super("Pong by Hubert Suprunowicz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        background = getContentPane();
        buildUI();

        setVisible(true);
    }

    public UserInterface() {
        super("Pong by Hubert Suprunowicz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Set app proportional to the user screen resolution */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight() - 35);

        background = getContentPane();
        buildUI();

        setVisible(true);
    }

    private void buildUI() {
        background.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        Board content = new Board();

        header.setBackground(Color.GRAY);
        content.setBackground(Color.BLACK);

        background.add(header, BorderLayout.NORTH);
        background.add(content, BorderLayout.CENTER);

        JButton startBtn = new JButton("START");
        JButton endBtn = new JButton("END");
        JButton stopBtn = new JButton("STOP");

        header.add(startBtn);
        header.add(endBtn);
        header.add(stopBtn);
    }


}
