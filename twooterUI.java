import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class twooter
{
    public twooter()
    {
        JFrame board = new JFrame("Twooter");
        JPanel panel = new JPanel();

        GridLayout grid = new GridLayout(4,4);

        board.setSize(400,400);
        panel.setSize(400,400);
        panel.setLayout(grid);

        board.setTitle("Twooter");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}