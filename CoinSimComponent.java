/**
 * Name: De Huo
 * USC NetId: dehuo
 * CSCI 455 PA1
 * Fall 2019
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.lang.Math;

/**
 * class CoinSimComponent
 * 
 * Extends JComponent. 
 * Constructor initializes any necessary data and runs the simulation. 
 * Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph.
 * 
 */

public class CoinSimComponent extends JComponent 
{

    private int timesOf2Heads, timesOf2Tails, timesOfHeadTail;
    private int unitsOf2Heads, unitsOf2Tails, unitsOfHeadTail;

    //Some geometric parameters to locate bars in the frame.
    private int widthOfBars, space, bottom, vb;
    private double scale;

    /**
     * Constant values for calculating the geometric parameters such as width of bars.
     * These ratio values make the size and the location of components accosiate with the size of frame.
     */
    public static final double BAR_WIDTH_RATIO = 8.0;
    public static final double SPACE_RATIO = 4.0;
    public static final double VERTICAL_BUFFER_RATIO = 8.0;
    public static final double BOTTOM_RATIO = 1.3;

    /**
     * Initializes any necessary data and runs the simulation.
     * @param totalTrials the given number of trials
     * @param widthOfFrame the width of window
     * @param heightOfFrame the height if window
     */
    public CoinSimComponent(int totalTrials, int widthOfFrame, int heightOfFrame) 
    {
        CoinTossSimulator newToss = new CoinTossSimulator();
        newToss.run(totalTrials);
        timesOf2Heads = newToss.getTwoHeads();
        timesOf2Tails = newToss.getTwoTails();
        timesOfHeadTail = newToss.getHeadTails();

        //Getting units of each case, they adding up to 100.
        unitsOf2Heads = (int) (Math.round(100.0 * timesOf2Heads / totalTrials));
        unitsOf2Tails = (int) (Math.round(100.0 * timesOf2Tails / totalTrials));
        unitsOfHeadTail = (int) (Math.round(100.0 * timesOfHeadTail / totalTrials));

        //Computing geometric parameters.
        widthOfBars = (int) (Math.round(widthOfFrame / BAR_WIDTH_RATIO));
        space = (int) (Math.round(widthOfFrame / SPACE_RATIO));
        vb = (int) (Math.round(heightOfFrame / VERTICAL_BUFFER_RATIO));
        bottom = (int) (heightOfFrame - vb * BOTTOM_RATIO);
        scale = (bottom - vb) / 100.0;
    }

    /**
     * Draws 3 bars, each of which represents the proportion of corresponding case's arising times.
     */
    public void paintComponent(Graphics g)
    {  
        Graphics2D g2 = (Graphics2D) g;

        Bar TwoHeads = new Bar(bottom, (int)(space - widthOfBars / 2.0), widthOfBars, unitsOf2Heads, 
                                scale, Color.BLUE, "Two Heads: " + timesOf2Heads + "(" + unitsOf2Heads + "%)");
        Bar HeadTail = new Bar(bottom, (int)(2.0 * space - widthOfBars / 2.0), widthOfBars, unitsOfHeadTail, 
                                scale, Color.YELLOW, "One-head One-tail: " + timesOfHeadTail + "(" + unitsOfHeadTail + "%)");
        Bar TwoTails = new Bar(bottom, (int)(3.0 * space - widthOfBars / 2.0), widthOfBars, unitsOf2Tails, 
                                scale, Color.RED, "Two Tails: " + timesOf2Tails + "(" + unitsOf2Tails + "%)");

        TwoHeads.draw(g2);
        TwoTails.draw(g2); 
        HeadTail.draw(g2);
        
    }
}
