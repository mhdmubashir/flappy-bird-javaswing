import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel {
    int bWidth = 360;
    int bHeight = 640;

    FlappyBird() {
        setPreferredSize(new Dimension(bWidth, bHeight));
        setBackground(Color.blue);
    }
}