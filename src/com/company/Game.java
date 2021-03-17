package com.company;
import java.util.Scanner;
import com.company.Story;
import com.company.Parts.Stage;

public class Game {
    private String state;
    private boolean run;
    private Scanner sc;
    private Story st;

    public Game() {
        // Important objects and object attributes to the game
        this.state = "lose";
        this.run = true;
        this.sc = new Scanner(System.in);
        this.st = new Story();
    }
    public void run() {
        // Game loop, every game has one
        // Controls beginning, middle, end, etc parts of the game
        while (this.run) {
            this.instructions(); // Gives instructions
            st.sequence();
	    this.finalMessage();
            if (this.restart()) { this.run = true; } // Resets the game to play again
            else {
                this.run = false; // Ends game
            }
        }
    }

    private boolean restart() {
        // Takes care of replaying or quitting options
        boolean playAgain = false;
        System.out.print("Would you like to play again? (y / n):  ");
        String response = this.sc.next(); // Gets the user input
        if (response.equals("y")) {
            playAgain = true; // Game continues
        } else if (response.equals("n")) {
            System.out.println("Play again next time!");
            playAgain = false; // Ends game
        } else {
            System.out.println("Please type a valid response!");
            this.restart();
        }
        return playAgain;
    }

    private void instructions() {
        // Tells the user how to play and introduces the game
        System.out.println("Welcome to the Pirates of the Seventh Sea!");
        System.out.println("The instructions are as follows");
        System.out.println("-    Anytime there is a blank line, simply click 'Enter' to read the next line");
        System.out.println("-    Your goal is to make it to the end alive and achieve the goal which will be " +
                "introduced later.");
        System.out.println("Now, without further ado, play the game! Enjoy!");
    }

    private void finalMessage() {
	// Just a bit of a fun message
	Stage.line();
	System.out.println("Based off of our algorithms, we got the following attributes:");
	System.out.println("     - You are brave          -");
	System.out.println("     - You are greedy         -");
	System.out.println("     - You are crazy          -");
	System.out.println("     - You tried your best ;) -");
	Stage.line();
	System.out.print("If you didn't make it to the end, there was a battleship game against a beast. If you want to play it, press (p), otherwise just click 'Enter':    ");
	String again = this.sc.nextLine();
	if (again.equals("p")) {
	    Battle battle = new Battle();
	    battle.run();
	}
    }
}
