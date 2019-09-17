/**
 * Name: De Huo
 * USC NetId: dehuo
 * CSCI 455 PA1
 * Fall 2019
 */

/**
 * Test driver for class CoinTossSimulator.
 * We specify 4 tests with incremental number of trials: 1, 10, 100, 1000
 * 
 * 
 */

 public class CoinTossSimulatorTester
 {
    public static void main (String[] args)
    {
        int Trials = 0;
        
        CoinTossSimulator newToss = new CoinTossSimulator();
        System.out.println("After constructor:");
        System.out.println("Number of trials [exp:0]: " + newToss.getNumTrials());
        System.out.println("Two-head tosses [exp:0]: " + newToss.getTwoHeads());
        System.out.println("Two-tail tosses [exp:0]: " + newToss.getTwoTails());
        System.out.println("One-head one-tail tosses [exp:0]: " + newToss.getHeadTails());
        System.out.print("Tosses add up correctly?");
        if (newToss.getNumTrials() == Trials)
            System.out.println("true");
        else 
            System.out.println("false");
        System.out.println();
        

        Trials = 1;
        newToss.run(Trials);
        System.out.println("After run(1):");
        System.out.println("Number of trials [exp:1]: " + newToss.getNumTrials());
        System.out.println("Two-head tosses: " + newToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + newToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + newToss.getHeadTails());
        System.out.println("Tosses add up correctly?");
        if (newToss.getNumTrials() == Trials)
            System.out.println("true");
        else 
            System.out.println("false");
        System.out.println();
        newToss.reset();
          
        
        Trials = 10;
        newToss.run(Trials);
        System.out.println("After run(10):");
        System.out.println("Number of trials [exp:10]: " + newToss.getNumTrials());
        System.out.println("Two-head tosses: " + newToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + newToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + newToss.getHeadTails());
        System.out.println("Tosses add up correctly?");
        if (newToss.getNumTrials() == Trials)
            System.out.println("true");
        else 
            System.out.println("false");
        System.out.println();
        newToss.reset();


        Trials = 100;
        newToss.run(Trials);
        System.out.println("After run(100):");
        System.out.println("Number of trials [exp:100]: " + newToss.getNumTrials());
        System.out.println("Two-head tosses: " + newToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + newToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + newToss.getHeadTails());
        System.out.println("Tosses add up correctly?");
        if (newToss.getNumTrials() == Trials)
            System.out.println("true");
        else 
            System.out.println("false");
        System.out.println();
        newToss.reset();


        Trials = 1000;
        newToss.run(Trials);
        System.out.println("After run(1000):");
        System.out.println("Number of trials [exp:1000]: " + newToss.getNumTrials());
        System.out.println("Two-head tosses: " + newToss.getTwoHeads());
        System.out.println("Two-tail tosses: " + newToss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + newToss.getHeadTails());
        System.out.println("Tosses add up correctly?");
        if (newToss.getNumTrials() == Trials)
            System.out.println("true");
        else 
            System.out.println("false");
        System.out.println();    
        newToss.reset();

    }

 }