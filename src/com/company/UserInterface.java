package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame  {
    private Container content;


    public UserInterface() {
        super("Pong by Hubert Suprunowicz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setResizable(false);

        /* Set app proportional to the user screen resolution */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());

        content = getContentPane();
        buildUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buildUI() {
        content.setLayout(new BorderLayout());
        content.setBackground(Color.WHITE);

        JPanel userPanel = new JPanel();
        Board board = new Board(300, 200);

        content.add(userPanel, BorderLayout.PAGE_START);
        content.add(board, BorderLayout.CENTER);

        pack();

        userPanel.setBackground(Color.GRAY);
        board.setBackground(Color.BLACK);

        JButton startBtn = new JButton("START");
        startBtn.addActionListener(e -> board.startGame());

        JButton endBtn = new JButton("END");
        endBtn.addActionListener(e -> board.endGame());

        JButton stopBtn = new JButton("STOP");
        stopBtn.addActionListener(e -> board.stopGame());

        userPanel.add(startBtn);
        userPanel.add(endBtn);
        userPanel.add(stopBtn);
    }







}
