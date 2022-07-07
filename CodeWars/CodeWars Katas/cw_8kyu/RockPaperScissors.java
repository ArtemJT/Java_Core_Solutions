package cw_8kyu;

/**
 Rock Paper Scissors
 Let's play! You have to return which player won! In case of a draw return Draw!.

 Examples(Input1, Input2 --> Output):

 "scissors", "paper" --> "Player 1 won!"
 "scissors", "rock" --> "Player 2 won!"
 "paper", "paper" --> "Draw!"
 */

public class RockPaperScissors {
    public static String rps(String p1, String p2) {
        String rock = "rock";
        String scissors = "scissors";
        String paper = "paper";
        String wP1 = "Player 1 won!";
        String wP2 = "Player 2 won!";
        String draw = "Draw!";
        if (p1.equals(rock) && p2.equals(scissors))
            return wP1;
        if (p1.equals(scissors) && p2.equals(paper))
            return wP1;
        if (p1.equals(paper) && p2.equals(rock))
            return  wP1;

        if (p1.equals(scissors) && p2.equals(rock))
            return wP2;
        if (p1.equals(paper) && p2.equals(scissors))
            return wP2;
        if (p1.equals(rock) && p2.equals(paper))
            return wP2;

        if (p1.equals(rock) && p2.equals(rock))
            return draw;
        if (p1.equals(scissors) && p2.equals(scissors))
            return draw;
        if (p1.equals(paper) && p2.equals(paper))
            return draw;
        return null;
    }
}
