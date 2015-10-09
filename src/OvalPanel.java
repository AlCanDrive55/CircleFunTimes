/**
 * Created by Alan Flood on 17/03/15.
 * Student No. B00083911
 * Software Engineering 2
 * BN509 FT
 * Circle Fun Timers Version 1.0
 */

import java.awt.*;
import javax.swing.*;

public class OvalPanel extends JPanel
{
    private int diameter = 0;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int alpha = 255;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //Renders the circle using a 2D graphics engine
        int x = 0; int y= 0; //Initialised to center the circle in the canvas
        int radius = diameter/2;
        g2.setColor(new Color(red, green, blue, alpha)); //Sets the circle's color values as 4 variables
        g2.fillOval(x - radius + 250, y - radius + 250, diameter, diameter);
    }

    public void setDiameter(int newDiameter)
    {
        diameter = (newDiameter >= 0 ? newDiameter : 500);
        repaint();
    }

    public void setRed(int newRed)
    {
        red = (newRed >= 0 ? newRed : 255);
        repaint();
    }

    public void setGreen(int newGreen)
    {
        green = (newGreen >= 0 ? newGreen : 255);
        repaint();
    }
    public void setBlue(int newBlue)
    {
        blue = (newBlue >= 0 ? newBlue : 255);
        repaint();
    }
    public void setAlpha(int newAlpha)
    {
        alpha = (newAlpha >= 0 ? newAlpha : 255);
        repaint();
    }
}