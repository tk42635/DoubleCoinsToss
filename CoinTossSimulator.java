// Name: De Huo 
// USC NetID: dehuo
// CS 455 PA1
// Fall 2019

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;//** */

public class CoinTossSimulator 
{

    private Random tossProbability;
    private int totalTrials;
    private int timesOf2Head, timesOf2Tail, timesOfHeadTail;
    private int isHead;
    


   /**
      Creates a coin toss simulator with no trials done yet.
   */
    public CoinTossSimulator() 
   {
        tossProbability = new Random();
        
        totalTrials = 0;
        timesOf2Head = 0;
        timesOf2Tail = 0;
        timesOfHeadTail = 0;

        isHead = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) 
   {
       for (int i = 0;i < numTrials;i++)
       {
            isHead = tossProbability.nextInt(2);
            if (isHead != 0)
            {
                isHead = tossProbability.nextInt(2);
                if (isHead != 0)
                    timesOf2Head ++;
                else 
                    timesOfHeadTail ++;
            }
            else
            {
                isHead = tossProbability.nextInt(2);
                if (isHead != 0)
                    timesOfHeadTail ++;
                else 
                    timesOf2Tail ++;
            }      
       
       }

   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials()
   {
       totalTrials = timesOf2Head + timesOf2Tail + timesOfHeadTail;
       return totalTrials; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads()
   {
       return timesOf2Head; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails()
   {
       return timesOf2Tail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails()
   {
       return timesOfHeadTail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset()
   {
        tossProbability = new Random();
        totalTrials = 0;
        timesOf2Head = 0;
        timesOf2Tail = 0;
        timesOfHeadTail = 0;
        isHead = 0;

   }

}
