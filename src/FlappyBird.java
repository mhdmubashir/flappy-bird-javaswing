import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener{
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



   //gamelogic
   Bird bird;
   int velocityY = -6; //mepatt
   Timer gameLoop;


    FlappyBird() {
        setPreferredSize(new Dimension(bWidth, bHeight));
        //setBackground(Color.blue);
        
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
        bird.y +=velocityY;
        bird.y = Math.max(bird.y, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}