package org.matthauer;

/**
 * Hello world!
 *
 */
public class CritFinder
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            if(args.length >= 2){
                doParameters(args);
            } else {
                doInteractive();
            }
        } catch (Exception e) {
            // lazy exception handling, catches IOException from readLine,
            //  NumberFormatException from parse, and Exception from
            //  invalid sides/goals in fOSC.
            e.printStackTrace();
            System.out.println("Invalid input!");
        }
    }

    private static void doParameters(String[] args) throws Exception {
        int sides = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        double r = new CritFinder().findOneShotChance(sides, goal);
    }

    private static void doInteractive() throws Exception {
        // prompt sides
        // get sides
        int sides = 0;
        // prompt goal
        // get goal
        int goal = 0;
        double r = new CritFinder().findOneShotChance(sides, goal);
    }

    /**
     * Returns the probability of rolling a one-shot critical hit.
     * @param sides       The number of sides on the die
     * @param goal        The target threshold to reach
     * @return            The probability of reaching that threshold
     * @throws Exception  On invalid input
     */
    public double findOneShotChance(int sides, int goal) throws Exception {
        // short-circuits
        if(sides < 1)
            throw new Exception("invalid number of sides");
        if(sides == 1){
            // fluke: guaranteed reroll, unlimited maximum.
            return 1.0;
        }
        if(goal < 1){
            throw new Exception("invalid goal value");
        }

        double reroll = 1.0/sides;
        int rerollsNeeded = goal / sides; // fluke of integer arithmatic, result is floor()
        double leftover = goal - (rerollsNeeded * sides);
        if(leftover == 0){
            return Math.pow(reroll, rerollsNeeded);
        } else {
            return (sides - leftover + 1) / (double) sides * Math.pow(reroll, rerollsNeeded);
        }
    }
}
