import java.swing.*;
public class App {
    public static void main(String args[]) {
        int bWidth = 360;
        int bHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        
        frame.setSize(bWidth, bHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappybird = new FlappyBird();
        frame.add(flappybird);
        frame.pack();
        frame.setVisible(true);
    }
}