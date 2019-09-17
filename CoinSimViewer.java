
/**
 * Name: De Huo
 * USC NetId: dehuo
 * CSCI 455 PA1
 * Fall 2019
 * 
 * 
 * This program simulates the process of double-coin tosses for given times and shows result in a bar graph.
 * Compile all the source files and run the main().
 */

import javax.swing.JFrame;
import java.util.Scanner;


public class CoinSimViewer
{
    public static final int widthOfFrame = 800; //Size of result window in pixels
    public static final int heightOfFrame = 500;

   public static void main(String[] args)
   {
        int totalTrials = 0;

        JFrame frame = new JFrame();

        frame.setSize(widthOfFrame, heightOfFrame);
        frame.setTitle("Double-Coin Tosses Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("Please enter the number of trials: ");
        Scanner in = new Scanner(System.in);
        totalTrials = in.nextInt();
        while (totalTrials <= 0)
        {
            System.out.println("Please enter a valid value(NO LESS THAN 0 & INTEGER): ");
            totalTrials = in.nextInt();
        }

        CoinSimComponent component = new CoinSimComponent(totalTrials, widthOfFrame, heightOfFrame);
        frame.add(component);
        frame.setVisible(true);

        System.out.println("Finished!");

   }
}
