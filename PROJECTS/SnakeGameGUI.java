import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGameGUI extends JPanel implements KeyListener, ActionListener {

    private final int screenWidth = 600;
    private final int screenHeight = 600;
    private final int unitSize = 25;
    private final int gameUnits = (screenWidth * screenHeight) / (unitSize * unitSize);
    private final int delay = 100;
    private final int[] snakeX = new int[gameUnits];
    private final int[] snakeY = new int[gameUnits];
    private int bodyParts = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean running = false;
    private Timer timer;
    private boolean allowWrapAround = true; // Flag to allow snake to wrap around

    private ArrayList<Point> obstacles = new ArrayList<>(); // List of obstacles
    private boolean spawnObstacles = true; // Flag to control obstacle spawning
    private final int obstacleCount = 15; // Number of obstacles
    private final int obstacleSize = 25; // Size of obstacles

    private boolean soundEnabled = true; // Flag to enable/disable sound
    private AudioClip eatSound;
    private AudioClip gameOverSound;

    private int score;
    private boolean showScoreboard = true;

    public SnakeGameGUI() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);

        // Load sound effects
        eatSound = loadSound("eat.wav");
        gameOverSound = loadSound("game_over.wav");

        startGame();
    }

    private AudioClip loadSound(String fileName) {
        URL fileURL = SnakeGameGUI.class.getResource(fileName);
        return Applet.newAudioClip(fileURL);
    }

    public void startGame() {
        running = true;
        score = 0;
        initSnake();
        spawnApple();
        if (spawnObstacles) {
            spawnObstacles();
        }
        timer = new Timer(delay, this);
        timer.start();
    }

    private void initSnake() {
        bodyParts = 1;
        for (int i = 0; i< bodyParts; i++) {
            snakeX[i] = 75 - i * unitSize;
            snakeY[i] = 75;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Draw snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(snakeX[i], snakeY[i], unitSize, unitSize);
            }

            // Draw apple
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitSize, unitSize);

            // Draw obstacles
            g.setColor(Color.gray);
            for (Point obstacle : obstacles) {
                g.fillRect(obstacle.x, obstacle.y, obstacleSize, obstacleSize);
            }

            // Draw scoreboard
            if (showScoreboard) {
                g.setColor(Color.white);
                g.setFont(new Font("SansSerif", Font.BOLD, 20));
                g.drawString("Score: " + score, 10, 20);
            }

        } else {
            gameOver(g);
        }
    }

    public void spawnApple() {
        Random random = new Random();
        appleX = random.nextInt((screenWidth / unitSize)) * unitSize;
        appleY = random.nextInt((screenHeight / unitSize)) * unitSize;
    }

    public void spawnObstacles() {
        Random random = new Random();
        for (int i = 0; i < obstacleCount; i++) {
            int x = random.nextInt((screenWidth / obstacleSize)) * obstacleSize;
            int y = random.nextInt((screenHeight / obstacleSize)) * obstacleSize;
            obstacles.add(new Point(x, y));
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        switch (direction) {
            case 'U':
                snakeY[0] = snakeY[0] - unitSize;
                break;
            case 'D':
                snakeY[0] = snakeY[0] + unitSize;
                break;
            case 'L':
                snakeX[0] = snakeX[0] - unitSize;
                break;
            case 'R':
                snakeX[0] = snakeX[0] + unitSize;
                break;
        }

        // Allow snake to wrap around the game board
        if (allowWrapAround) {
            if (snakeX[0] >= screenWidth) {
                snakeX[0] = 0;
            } else if (snakeX[0] < 0) {
                snakeX[0] = screenWidth - unitSize;
            }
            if (snakeY[0] >= screenHeight) {
                snakeY[0] = 0;
            } else if (snakeY[0] < 0) {
                snakeY[0] = screenHeight - unitSize;
            }
        }
    }

    public void checkApple() {
        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            bodyParts++;
            applesEaten++;
            score += 10; // Increase score
            spawnApple();
            if (soundEnabled && eatSound != null) {
                eatSound.play();
            }
        }
    }

    public void checkObstacles() {
        for (Point obstacle : obstacles) {
            if (snakeX[0] == obstacle.x && snakeY[0] == obstacle.y) {
                running = false;
                if (soundEnabled && gameOverSound != null) {
                    gameOverSound.play();
                }
                break;
            }
        }
    }

    public void checkCollisions() {
        // Check if snake collides with itself
        for (int i = bodyParts; i > 0; i--) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                running = false;
                if (soundEnabled && gameOverSound != null) {
                    gameOverSound.play();
                }
                break;
            }
        }

        // Check if snake touches border
        if (!allowWrapAround) {
            if (snakeX[0] < 0 || snakeX[0] >= screenWidth || snakeY[0] < 0 || snakeY[0] >= screenHeight) {
                running = false;
                if (soundEnabled && gameOverSound != null) {
                    gameOverSound.play();
                }
            }
        }
    }

    public void gameOver(Graphics g) {
        // Game over text
        g.setColor(Color.red);
        g.setFont(new Font("SansSerif", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics.stringWidth("Game Over")) / 2, screenHeight / 2);

        // Display final score
        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        FontMetrics scoreMetrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + score, (screenWidth - scoreMetrics.stringWidth("Score: " + score)) / 2, screenHeight / 2 + 50);

        // Prompt to restart or quit
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("Press Enter to Restart", (screenWidth - metrics.stringWidth("Press Enter to Restart")) / 2, screenHeight / 2 + 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            if (spawnObstacles) {
                checkObstacles();
            }
            checkCollisions();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_ENTER:
                if (!running) {
                    restartGame();
                }
                break;
            case KeyEvent.VK_SPACE:
                soundEnabled = !soundEnabled;
                break;
        }
    }

    private void restartGame() {
        // Reset game variables
        bodyParts = 1;
        applesEaten = 0;
        score = 0;
        direction = 'R';
        running = true;
        obstacles.clear();
        initSnake();
        spawnApple();
        if (spawnObstacles) {
            spawnObstacles();
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGameGUI snakeGame = new SnakeGameGUI();
        frame.add(snakeGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}