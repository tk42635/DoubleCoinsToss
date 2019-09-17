/**
 * Author: De Huo 
 * Net ID: dehuo
 * USC CSCI455
 * Program Assignment I
 */

import javax.swing.JFrame;
import java.util.Scanner;


public class CoinSimViewer
{
    public static final int widthOfFrame = 200; //Pixels
    public static final int heightOfFrame = 100;

   public static void main(String[] args)
   {
        int totalTrials = 0;

        JFrame frame = new JFrame();

        frame.setSize(widthOfFrame, heightOfFrame);
        frame.setTitle("Coin Toss Results");
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
