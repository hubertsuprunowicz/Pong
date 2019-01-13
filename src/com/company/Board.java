package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Board extends JPanel {
    private Timer time;
    private Ball ball;
    private Player player, ai;


    // To avoid moving the rocket until the game starts
    private Integer tempPlayerY;

    /* get resolution from UI class*/
    private Integer boardWidth, boardHeight;

    private JLabel leftScore;
    private JLabel rightScore;

    Board(Integer width, Integer height) {
        super();
        this.boardWidth = width;
        this.boardHeight = height;
        setLayout(new GridLayout(1,2));
        buildScoreboard();

        //int startDx = ThreadLocalRandom.current().nextInt(-10, 10+1);l
        final int PADDING = 10;
        Integer ballWidth = boardWidth/100;
        Integer ballHeight = ballWidth;
        Integer racketWidth = 5;
        Integer racketHeight = boardHeight/4;

        ball = new Ball(boardWidth/2,boardHeight/2, ballWidth, ballHeight, new Direction(5).getDirection(), new Direction(5).getDirection());
        player = new Player(PADDING,boardHeight/2, racketWidth, racketHeight, 0, 0);
        ai = new Player(boardWidth - PADDING,boardHeight/2, racketWidth, racketHeight, 0, 0);

        // Binding Keys
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down");

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "upS");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "downS");

        // Actions taken for specified ID key
        ActionMap ap = this.getActionMap();
        ap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dy = -8;
            }
        });
        ap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dy = 8;
            }
        });

        ap.put("upS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dy = 0;
            }
        });
        ap.put("downS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.dy = 0;
            }
        });


        time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(Math.sin(-1) + " " + Math.cos(-1));

                ball.isMoving(player.dy);
                ball.move(width, height, ai.x, ai.y, player.x, player.y);
                player.move(width, height, 0, 10,0, 0);
                ai.move(width, height, 0, 10, ball.x, ball.y);

                repaint();

                if(ball.leftWallCollide()) {
                    ai.points++;
                    rightScore.setText(ai.points.toString());
                    reset();
                } else if(ball.rightWallCollide(width)) {
                    player.points++;
                    leftScore.setText(player.points.toString());
                    reset();
                }
            }
        });
    }

    private void buildScoreboard() {
        leftScore = new JLabel("0", SwingConstants.CENTER);
        leftScore.setFocusable(false);
        leftScore.setFont( new Font("SansSerif", Font.BOLD, boardHeight/2 + boardHeight/4));
        leftScore.setBorder(null);
        leftScore.setForeground(new Color(0.5f,0.5f,0.5f,.1f ));
        leftScore.setBackground(new Color(0f,0f,0f,.0f ));
        this.add(leftScore);

        rightScore = new JLabel("0", SwingConstants.CENTER);
        rightScore.setFocusable(false);
        rightScore.setFont( new Font("SansSerif", Font.BOLD, boardHeight/2 +  boardHeight/4));
        rightScore.setBorder(null);
        rightScore.setForeground(new Color(0.5f,0.5f,0.5f,.1f ));
        rightScore.setBackground(new Color(0f,0f,0f,.0f ));
        this.add(rightScore);
    }

    private void add(String item) {
        switch (item.toLowerCase()) {
            case "ball":
                ball.x = boardWidth/2;
                ball.y = boardHeight/2;
                ball.dx = new Direction(5).getDirection();
                ball.dy = new Direction(5).getDirection();
                repaint();
                break;

            case "player":
                player.x = 10;
                player.y = boardHeight/2;
                ai. x = boardWidth-10;
                ai.y = boardHeight/2;
                repaint();
                break;

            default:
                // TRY CATCH EXCEPTION
                break;
        }
    }

    private void reset() {
        add("player");
        add("ball");
        time.stop();
    }

    public void stopGame() {
        tempPlayerY = player.y;
        time.stop();
    }

    public void startGame() {
        time.start();
        player.y = Objects.requireNonNullElse(tempPlayerY, player.y);
    }

    public void endGame() {
        add("player");
        add("ball");
        player.points = 0;
        ai.points = 0;
        rightScore.setText("0");
        leftScore.setText("0");
        tempPlayerY = player.y;
        time.stop();
    }

    @Override
    public Dimension getPreferredSize() {
        // After rendering panel is getting minus 26 of initialised size
        return new Dimension(this.boardWidth,this.boardHeight + 26);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player.draw(g);
        ai.draw(g);
        g.drawLine(boardWidth/2,0,boardWidth/2, boardHeight);
        g.drawOval(boardWidth/2 - boardWidth/8, boardHeight/2 - boardHeight/4, boardWidth/4, boardHeight/2);

        this.boardWidth = getWidth();
        this.boardHeight = getHeight();
    }

}
