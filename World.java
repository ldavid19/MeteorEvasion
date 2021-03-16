//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class World {
    private ArrayList<Sprite> sprites;
    private ArrayList<Sprite> level1;
    private ArrayList<Sprite> level2;
    private ArrayList<Sprite> level3;
    private ArrayList<Sprite> level4;
    private ArrayList<Sprite> level5;
    private ArrayList<Sprite> level6;
    private ArrayList<String> scores;
    private ArrayList<Integer> realScores;
    private ArrayList<String> names;
    private int width;
    private int height;
    private Spaceship coolShip;
    private boolean rightKeyDown;
    private boolean leftKeyDown;
    private boolean upKeyDown;
    private boolean downKeyDown;
    private boolean startGame;
    private long startTime;
    private boolean beginningScreen;
    private Sprite startButton;
    private boolean makeBall;
    private Ball baller1;
    private Ball baller2;
    private Ball baller3;
    private Ball baller4;
    private Ball baller5;
    private Ball baller6;
    private Ball baller7;
    private Ball baller8;
    private Display display;
    String user = "null";
    boolean newUser = false;
    int seconds = 0;
    int messageSeconds = 0;
    int newLine = 195;
    String longestSurviver = "0:00";

    public static void main(String[] args) {
        Display display = new Display(1200, 700);
        display.run();
    }

    public World(Display disp, int w, int h) {
        this.width = w;
        this.height = h;
        this.display = disp;
        this.sprites = new ArrayList();
        this.scores = new ArrayList();
        this.realScores = new ArrayList();
        this.names = new ArrayList();
        this.startButton = new Sprite(600.0D, 350.0D, 100, 100, "startbutton.png");
        this.coolShip = new Spaceship();
        double position = 375.0D + Math.random() * 325.0D;
        this.level1 = new ArrayList();
        this.level2 = new ArrayList();
        this.level3 = new ArrayList();
        this.level4 = new ArrayList();
        this.level5 = new ArrayList();
        this.baller1 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller2 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller3 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller4 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller5 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller6 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller7 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller8 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.sprites.add(this.coolShip);
        this.sprites.add(this.baller1);
        this.sprites.add(this.baller2);
        this.sprites.add(this.baller3);
        this.startTime = System.currentTimeMillis();
    }

    public void stepAll() {
        long timee = System.currentTimeMillis();
        int timeee = (int)timee;
        if (timeee % 1000 == 0) {
            this.makeBall = true;
        }

        for(int i = 1; i < this.sprites.size(); ++i) {
            if (timeee % 1000 == 0 && this.seconds != 0 && this.makeBall) {
                this.sprites.add(new Ball(375.0D + Math.random() * 325.0D, 3.0D));
                this.makeBall = false;
            }

            Sprite s = (Sprite)this.sprites.get(i);
            s.step(this);
        }

        if (this.rightKeyDown && this.coolShip.getLeft() <= 1146.0D && this.coolShip.getLeft() >= 375.0D) {
            this.coolShip.setLeft(this.coolShip.getLeft() + 4.0D);
        }

        if (this.leftKeyDown && this.coolShip.getLeft() > 379.0D && this.coolShip.getLeft() <= 1150.0D) {
            this.coolShip.setLeft(this.coolShip.getLeft() - 4.0D);
        }

        if (this.upKeyDown && this.coolShip.getTop() <= 646.0D && this.coolShip.getTop() >= 0.0D) {
            this.coolShip.setTop(this.coolShip.getTop() + 4.0D);
        }

        if (this.downKeyDown && this.coolShip.getTop() > 4.0D && this.coolShip.getTop() <= 650.0D) {
            this.coolShip.setTop(this.coolShip.getTop() - 4.0D);
        }

        if (this.coolShip.isOrAlreadyHit()) {
            JOptionPane.showMessageDialog(this.display, "You survived for  " + this.messageSeconds + "  seconds.  " + "Enter your REAL NAME after clicking OK");
            JFrame frame = new JFrame("InputDialog Example #1");
            String name = JOptionPane.showInputDialog(frame, "What's your name?");
            if (this.seconds >= 10) {
                this.user = name + "  00:" + this.seconds;
            }

            if (this.seconds < 10) {
                this.user = name + "  00:0" + this.seconds;
            }

            if (this.seconds >= 60 && this.seconds < 70) {
                this.user = name + "  01:0" + (60 - this.seconds);
            }

            if (this.seconds >= 70 && this.seconds < 120) {
                this.user = name + "  01:" + (60 - this.seconds);
            }

            if (this.seconds >= 120 && this.seconds < 130) {
                this.user = name + "  02:0" + (120 - this.seconds);
            }

            if (this.seconds >= 130 && this.seconds < 180) {
                this.user = name + "  02:" + (120 - this.seconds);
            }

            this.realScores.add(this.seconds);
            this.names.add(name);
            System.out.printf("The user's name is '%s'.\n", name);
            System.out.println(this.user);
            this.reset();
        }

    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getNumSprites() {
        return this.sprites.size();
    }

    public Sprite getSprite(int index) {
        return (Sprite)this.sprites.get(index);
    }

    public void mouseClicked(int x, int y) {
        System.out.println("mouseClicked:  " + x + ", " + y);
    }

    public void keyPressed(int key) {
        System.out.println("keyPressed:  " + key);
        if (key == 39) {
            this.rightKeyDown = true;
        }

        if (key == 37) {
            this.leftKeyDown = true;
        }

        if (key == 40) {
            this.upKeyDown = true;
        }

        if (key == 38) {
            this.downKeyDown = true;
        }

    }

    public void keyReleased(int key) {
        System.out.println("keyReleased:  " + key);
        if (key == 39) {
            this.rightKeyDown = false;
        }

        if (key == 37) {
            this.leftKeyDown = false;
        }

        if (key == 40) {
            this.upKeyDown = false;
        }

        if (key == 38) {
            this.downKeyDown = false;
        }

    }

    public String getTitle() {
        return "World";
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.width, this.height);
        g.setColor(Color.GREEN);
        g.fillRect(350, 0, 25, 700);
        g.setColor(Color.WHITE);
        g.drawString("I forgot the name of this game", 95, 20);

        int newLineforLoop;
        for(newLineforLoop = 0; newLineforLoop < this.sprites.size(); ++newLineforLoop) {
            Sprite sprite = (Sprite)this.sprites.get(newLineforLoop);
            g.drawImage(Display.getImage(sprite.getImage()), (int)sprite.getLeft(), (int)sprite.getTop(), sprite.getWidth(), sprite.getHeight(), (ImageObserver)null);
        }

        newLineforLoop = 195;

        String currentLeader;
        int highestScore;
        for(highestScore = 0; highestScore < this.scores.size(); ++highestScore) {
            currentLeader = (String)this.scores.get(highestScore);
            if (newLineforLoop <= this.newLine) {
                g.drawString(currentLeader, 75, newLineforLoop);
                if (newLineforLoop != this.newLine) {
                    newLineforLoop += 15;
                }
            }
        }

        g.setColor(Color.YELLOW);
        g.drawString("Leader Board", 75, 180);
        highestScore = 0;
        currentLeader = "Nobody";

        for(int i = 0; i < this.realScores.size(); ++i) {
            int hahaWhatever = (Integer)this.realScores.get(i);
            String hahaWhatevs = (String)this.names.get(i);
            if (highestScore < hahaWhatever) {
                highestScore = hahaWhatever;
                currentLeader = hahaWhatevs;
            }
        }

        String highestScoreinString = "idk bro";
        if (highestScore >= 10) {
            highestScoreinString = "  00:" + highestScore;
        }

        if (highestScore < 10) {
            highestScoreinString = "  00:0" + highestScore;
        }

        if (highestScore >= 60 && highestScore < 70) {
            highestScoreinString = "  01:0" + (60 - highestScore);
        }

        if (highestScore >= 70 && highestScore < 120) {
            highestScoreinString = "  01:" + (60 - highestScore);
        }

        if (highestScore >= 120 && highestScore < 130) {
            highestScoreinString = "  02:0" + (120 - highestScore);
        }

        if (highestScore >= 130 && highestScore < 180) {
            highestScoreinString = "  02:" + (120 - highestScore);
        }

        g.setColor(Color.PINK);
        g.drawString(currentLeader + " Has Survived The Longest", 20, 115);
        g.drawString("With   ", 80, 130);
        g.setColor(Color.GREEN);
        g.drawString(highestScoreinString, 120, 130);
        g.setColor(Color.PINK);
        g.drawString("!!", 180, 130);
        g.setColor(Color.WHITE);
        long elapsedTime = System.currentTimeMillis() - this.startTime;
        long elapsedSeconds = elapsedTime / 1000L;
        long secondsDisplay = elapsedSeconds % 60L;
        int minutes = 0;
        if (elapsedSeconds < 10L) {
            if (minutes < 10) {
                g.drawString("Time: 0" + minutes + ":" + "0" + elapsedSeconds, 90, 70);
                this.seconds = (int)elapsedSeconds;
                this.messageSeconds = (int)elapsedSeconds;
            } else {
                g.drawString("Time: " + minutes + ":" + "0" + elapsedSeconds, 90, 70);
                this.seconds = (int)elapsedSeconds;
                this.messageSeconds = (int)elapsedSeconds;
            }
        } else if (minutes < 10) {
            g.drawString("Time: 0" + minutes + ":" + elapsedSeconds, 90, 70);
            this.seconds = (int)elapsedSeconds;
            this.messageSeconds = (int)elapsedSeconds;
        } else {
            g.drawString("Time: " + minutes + ":" + elapsedSeconds, 90, 70);
            this.seconds = (int)elapsedSeconds;
            this.messageSeconds = (int)elapsedSeconds;
        }

        if (elapsedSeconds >= 60L) {
            this.startTime = System.currentTimeMillis();
            int var16 = minutes + 1;
            this.seconds = (int)elapsedSeconds;
        }

    }

    public Spaceship getSpaceship() {
        return this.coolShip;
    }

    public void reset() {
        this.sprites = new ArrayList();
        this.startButton = new Sprite(600.0D, 350.0D, 100, 100, "startbutton.png");
        this.coolShip = new Spaceship();
        this.level1 = new ArrayList();
        this.level2 = new ArrayList();
        this.level3 = new ArrayList();
        this.level4 = new ArrayList();
        this.level5 = new ArrayList();
        this.baller1 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller2 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller3 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller4 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller5 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller6 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller7 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.baller8 = new Ball(375.0D + Math.random() * 325.0D, 3.0D);
        this.sprites.add(this.coolShip);
        this.sprites.add(this.baller1);
        this.sprites.add(this.baller2);
        this.sprites.add(this.baller3);
        this.startTime = System.currentTimeMillis();
        this.coolShip.resetHit();
        this.coolShip.setLeft(825.0D);
        this.coolShip.setTop(650.0D);
        this.rightKeyDown = false;
        this.leftKeyDown = false;
        this.upKeyDown = false;
        this.downKeyDown = false;
        this.scores.add(this.user);
        this.newLine += 15;
    }
}
