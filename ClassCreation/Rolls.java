// Rolls - client class for demonstrating the Counter class
//
// This program creates an array of Counter objects, each of which
// represents the number of times that side of a N-sided die has
// come up on a random roll.
//
// The counter objects are given the names "1s", "2s", etc.

public class Rolls {
    
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Rolls <N>");
            System.out.println("    rolls a die N times and prints the results");
            return;
        }

        final int numSides = 6;

        int numRolls = Integer.parseInt(args[0]);

        Counter[] rolls = new Counter[numSides];
        for (int i = 0; i < numSides; i++) {
            String name = String.format ("%ds", i+1);
            rolls[i] = new Counter(name);
        }

        for (int i = 0; i < numRolls; i++) {
            int side = RandomUtils.uniform(numSides);
            rolls[side].increment();
        }

        for (int i = 0; i < numSides; i++) {
            System.out.println(rolls[i]);
        }
    }
}
