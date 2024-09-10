import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel {
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
   


    FlappyBird() {
        setPreferredSize(new Dimension(bWidth, bHeight));
        //setBackground(Color.blue);
        
        //loadimage
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImgImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
      
        //bird
        bird = new Bird(birdImg);
        
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //bg
        g.drawImage(backgroundImg, 0, 0, bWidth, bHeight)

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }
}