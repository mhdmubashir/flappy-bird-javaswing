import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener{
    int bWidth = 360;
    int bHeight = 640;

    //images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //bird
    int birdX = bWidth/8;
    int birdY = bHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;
    
    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

   //Pipes
   int pipeX = bWidth;
   int pipeY = 0;
   int pipeWidth = 64; //1/6
   int pipeHeight = 512;

   class Pipe{
    int x = pipeX;
    int y = pipeY;
    int width = pipeWidth;
    int height = pipeHeight;
    Image img;
    boolean passed = false;

    Pipe(Image img) {
        this.img = img;
    }
   }


   //gamelogic
   Bird bird;
   int velocityX = -4; //move pipeto left speed, when bird move right
   int velocityY = 0; //movebird up down speed
   int gravity = 1;

   ArrayList<Pipe> pipes;
    
  
   Timer gameLoop;
   Timer placePipesTimer;


    FlappyBird() {
        setPreferredSize(new Dimension(bWidth, bHeight));
        //setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
        //loadimage
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
      
        //bird
        bird = new Bird(birdImg);

        

        //gametimer
        gameLoop = new Timer(1000/60, this); //1000/60 = 16.6
        gameLoop.start();
        
    }

    public void placePipes() {
        Pipe topPipe = new Pipe(topPipeImg);
        pipes.add(topPipe);
    }


    public void paintComponent (Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //bg
        g.drawImage(backgroundImg, 0, 0, bWidth, bHeight,null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

    public void move() {
        //bird
        velocityY +=gravity;
        bird.y +=velocityY;
        bird.y = Math.max(bird.y, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
      if(e.getKeyCode()== KeyEvent.VK_SPACE) {
        velocityY = -9;
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}