package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class UserInterface extends JFrame {
    private Container content;

    public UserInterface(Integer width, Integer height) {
        super("Pong by Hubert Suprunowicz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width,height);
        content = getContentPane();
        buildUI();

        setVisible(true);
    }

    public UserInterface() {
        super("Pong by Hubert Suprunowicz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        /* Set app proportional to the user screen resolution */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight() - 35);

        content = getContentPane();
        buildUI();

        setVisible(true);
    }

    private void buildUI() {
        content.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        Board board = new Board();

        header.setBackground(Color.GRAY);
        board.setBackground(Color.BLACK);

        content.add(header, BorderLayout.NORTH);
        content.add(board, BorderLayout.CENTER);

        //JOptionPane.showMessageDialog(null, dim.width);

        JButton startBtn = new JButton("START");
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.startGame();
            }
        });

        JButton endBtn = new JButton("END");
        endBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.add("ball");
                board.add("player");
            }
        });

        JButton stopBtn = new JButton("STOP");
        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.stopGame();
            }
        });


        header.add(startBtn);
        header.add(endBtn);
        header.add(stopBtn);
    }


}
