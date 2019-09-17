import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.lang.Math;

/**
 * This component draws the result of two-coin tosses.
 */

public class CoinSimComponent extends JComponent 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private int timesOf2Heads, timesOf2Tails, timesOfHeadTail;
    private int unitsOf2Heads, unitsOf2Tails, unitsOfHeadTail;
    private int widthOfBars, space, bottom, vb;
    private double scale;

    public static final double BAR_WIDTH_RATIO = 8.0;
    public static final double SPACE_RATIO = 4.0;
    public static final double VERTICAL_BUFFER_RATIO = 8.0;
    public static final double BOTTOM_RATIO = 1.3;

    public CoinSimComponent(int totalTrials, int widthOfFrame, int heightOfFrame) 
    {
        CoinTossSimulator newToss = new CoinTossSimulator();
        newToss.run(totalTrials);
        timesOf2Heads = newToss.getTwoHeads();
        timesOf2Tails = newToss.getTwoTails();
        timesOfHeadTail = newToss.getHeadTails();
        unitsOf2Heads = (int) (Math.round(100.0 * timesOf2Heads / totalTrials));
        unitsOf2Tails = (int) (Math.round(100.0 * timesOf2Tails / totalTrials));
        unitsOfHeadTail = (int) (Math.round(100.0 * timesOfHeadTail / totalTrials));
        
        widthOfBars = (int) (Math.round(widthOfFrame / BAR_WIDTH_RATIO));
        space = (int) (Math.round(widthOfFrame / SPACE_RATIO));
        vb = (int) (Math.round(heightOfFrame / VERTICAL_BUFFER_RATIO));
        bottom = (int) (heightOfFrame - vb * BOTTOM_RATIO) ;
        scale = (bottom - vb) / 100.0;
    }

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
