// Flips - client program for demonstrating the Counter class
//
// This program creates a pair of Counter objects with the names
// "heads" and "tails", which represent the number of times a
// flipped coin has come up heads or tails.

public class Flips {
    
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Flips <N>");
            System.out.println("    flips a coin N times and prints the results");
            return;
        }

        int numFlips = Integer.parseInt(args[0]);

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < numFlips; i++) {
            if (RandomUtils.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }

        System.out.println(heads);
        System.out.println(tails);
    }
}
