package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Board extends JPanel implements SizeObject {
    private Timer time;
    private Ball ball;
    private Player player, ai;

    // To avoid moving the rocket until the game starts
    private Integer tempPlayerY;

    /* get resolution from UI class*/
    private Integer width, height;

    private JLabel leftScore;
    private JLabel rightScore;

    Board(Integer width, Integer height) {
        super();

        this.height = height;
        this.width = width;

        setLayout(new GridLayout(1,2));
        buildScoreboard();

        ball = new Ball(width/2,height/2, BALL_WIDTH, BALL_HEIGHT,-8, -8, Color.RED);
        player = new Player(10 ,height/2, RACKET_WIDTH, RACKET_HEIGHT,0, 0, Color.WHITE);
        ai = new Player(width-10 ,height/2, RACKET_WIDTH, RACKET_HEIGHT,0, 0, Color.WHITE);

        // Binding Keys
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down");

        // Actions taken for specified ID key
        ActionMap ap = this.getActionMap();
        ap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.y -= 10;
            }
        });
        ap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.y += 10;
            }
        });


        time = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move(width, height, ai.x, ai.y, player.x, player.y);
                player.move(width, height, 0, 10,0, 0);
                ai.move(width, height, 0, 10, ball.x, ball.y);
                repaint();

                if(ball.leftWallCollide(width)) {
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

    public void buildScoreboard() {

        leftScore = new JLabel("0", SwingConstants.CENTER);
        leftScore.setFocusable(false);
        leftScore.setFont( new Font("SansSerif", Font.BOLD, height/2 + height/4));
        leftScore.setBorder(null);
        leftScore.setForeground(new Color(0.5f,0.5f,0.5f,.1f ));
        leftScore.setBackground(new Color(0f,0f,0f,.0f ));
        this.add(leftScore);

        rightScore = new JLabel("0", SwingConstants.CENTER);
        rightScore.setFocusable(false);
        rightScore.setFont( new Font("SansSerif", Font.BOLD, height/2 +  height/4));
        rightScore.setBorder(null);
        rightScore.setForeground(new Color(0.5f,0.5f,0.5f,.1f ));
        rightScore.setBackground(new Color(0f,0f,0f,.0f ));
        this.add(rightScore);
    }

    public void add(String item) {

        switch (item.toLowerCase()) {
            case "ball":
                ball.x = width/2;
                ball.y = height/2;
                repaint();
                break;

            case "player":
                player.x = 10;
                player.y = height/2;
                ai. x = width-10;
                ai.y = height/2;
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
        return new Dimension(this.width,this.height + 26);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player.draw(g);
        ai.draw(g);
        g.drawLine(width/2,0,width/2,height);
        g.drawOval(width/2 - width/8, height/2 - height/4, width/4, height/2);

        this.width = getWidth();
        this.height = getHeight();
    }

}
