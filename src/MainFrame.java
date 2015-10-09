/**
 * Created by Alan Flood on 17/03/15.
 * Student No. B00083911
 * Software Engineering 2
 * BN509 FT
 * Circle Fun Timers Version 1.0
 */

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.Math;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame
{
    private final JSlider diameterSlider;   //JSlider 1
    private final JSlider rSlider;          //JSlider 2
    private final JSlider gSlider;          //JSlider 3
    private final JSlider bSlider;          //JSlider 4
    private final JSlider aSlider;          //JSlider 5
    private final OvalPanel circlePanel;
    private final JLabel diameterReadout;
    private final JLabel areaReadout;
    private final JLabel circumferenceReadout;
    private final JLabel redReadout;
    private final JLabel greenReadout;
    private final JLabel blueReadout;
    private final JLabel alphaReadout;


    public MainFrame() {
        super("Circle Fun Times");

//Main Layout
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

//Panel to contain Sliders and their JLabels
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

//Panel to contain Canvas();
        circlePanel = new OvalPanel();
        circlePanel.setBackground(Color.WHITE);
        circlePanel.setBorder(BorderFactory.createLineBorder(Color.black));

//Sliders and JLabels//

    //Diameter Slider//
        diameterSlider =
                new JSlider(SwingConstants.HORIZONTAL, 0, 500, 0);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        c.gridwidth = 2;
        diameterSlider.setMajorTickSpacing(100);
        diameterSlider.setMinorTickSpacing(25);
        diameterSlider.setPaintTicks(true);
        diameterSlider.setPaintLabels(true);
        diameterSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        circlePanel.setDiameter(diameterSlider.getValue());
                        diameterReadout.setText("Diameter: " + diameterSlider.getValue());
                        int radius = diameterSlider.getValue()/2;
                        double area = Math.PI * (radius * radius);
                        double circumference = (2 * Math.PI) * radius;
                        areaReadout.setText(String.format("Area: %.3f", area));
                        circumferenceReadout.setText(String.format("Circumference: %.1f", circumference));
                    }
                }
        );
        sliderPanel.add(diameterSlider, c);

    //Circle Information Jlabels//

        //Diameter JLabel//
        diameterReadout = new JLabel("Diameter: 0");
        diameterReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        sliderPanel.add(diameterReadout, c);

        //Area JLabel//
        areaReadout = new JLabel("Area: 0");
        areaReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        sliderPanel.add(areaReadout, c);

        //Circumference JLabel//
        circumferenceReadout = new JLabel("Circumference: 0");
        circumferenceReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridwidth = 2;
        sliderPanel.add(circumferenceReadout, c);

    //Red Slider//
        rSlider =
                new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 2;
        rSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent r) {
                        circlePanel.setRed(rSlider.getValue());
                        int p = ((rSlider.getValue()*100)/255);
                        redReadout.setText("<html><font color=red>Red</font> : " +p +"%</html>");
                    }
                }
        );
        sliderPanel.add(rSlider, c);
        //Red JLabel//
        redReadout =
                new JLabel("<html><font color=red>Red</font> : -%</html>");
        redReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 3;
        c.gridheight = 1;
        sliderPanel.add(redReadout, c);

    //Green Slider//
        gSlider =
                new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 2;
        gSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent g) {
                        circlePanel.setGreen(gSlider.getValue());
                        int p = ((gSlider.getValue()*100)/255);
                        greenReadout.setText("<html><font color=green>Green</font> : " +p +"%</html>");
                    }
                }
        );
        sliderPanel.add(gSlider, c);
        //Green JLabel//
        greenReadout =
                new JLabel("<html><font color=green>Green</font> : -%</html>");
        greenReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 4;
        c.gridheight = 1;
        sliderPanel.add(greenReadout, c);

    //Blue Slider//
        bSlider =
                new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 2;
        bSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent b) {
                        circlePanel.setBlue(bSlider.getValue());
                        int p = ((bSlider.getValue()*100)/255);
                        blueReadout.setText("<html><font color=blue>Blue</font> : " +p + "%</html>");
                    }
                }
        );
        sliderPanel.add(bSlider, c);
        //Blue JLabel//
        blueReadout =
                new JLabel("<html><font color=blue>Blue</font> : -%</html>");
        blueReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 5;
        c.gridheight = 1;
        sliderPanel.add(blueReadout, c);

    //Alpha Slider//
        aSlider =
                new JSlider(SwingConstants.HORIZONTAL, 0, 255, 255);
        aSlider.setInverted(true);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 6;
        c.gridheight = 1;
        c.gridwidth = 2;
        aSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent a) {
                        circlePanel.setAlpha(aSlider.getValue());
                        int p = ((aSlider.getValue()*100)/255);
                        alphaReadout.setText("Transparency : " + p +"%");
                    }
                }
        );
        sliderPanel.add(aSlider, c);
        //Alpha JLabel//
        alphaReadout =
                new JLabel("Transparency : 100%");
        alphaReadout.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 6;
        c.gridheight = 1;
        sliderPanel.add(alphaReadout, c);

//Radio Buttons
    //Label for Radio buttons//
        JLabel backgroundLabel = new JLabel("   Background Color :");
        backgroundLabel.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 2;
        sliderPanel.add(backgroundLabel, c);
    //Change background to Black//
        JRadioButton backBlack = new JRadioButton("Black", false);
        backBlack.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 2;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 1;
                backBlack.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent b) {
                        circlePanel.setBackground(Color.BLACK);
                    }
                });
        sliderPanel.add(backBlack, c);
    //Change background to White (Default)//
        JRadioButton backWhite = new JRadioButton("White", true);
        backWhite.setPreferredSize(new Dimension(50, 20));
        c.weightx = 0.50;
        c.gridx = 3;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 1;
        backWhite.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent b) {
                circlePanel.setBackground(Color.WHITE);
            }
        });
        sliderPanel.add(backWhite, c);
    //Button Group to toggle background color//
        ButtonGroup background = new ButtonGroup();
        background.add(backWhite);
        background.add(backBlack);

//Add the two main Panels to the program//
        add(sliderPanel, BorderLayout.SOUTH);
        add(circlePanel, BorderLayout.CENTER);
    }
}

