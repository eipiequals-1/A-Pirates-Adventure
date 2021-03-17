package com.company;
import com.company.Parts.Stage;
import java.util.Scanner;

public class Battle {

    private Scanner sc;
    private String location; // Where the beast is located

    public Battle() {
	this.sc = new Scanner(System.in); // important object for getting user input
    }
    
    public boolean run() {
	// A battleship like game where the beast hides on a grid
	// The player's goal is to kill the beast to get the treasure he is guarding
	System.out.println("The beast is hiding in a 5x5 grid. Try to kill it with your cannons before it gets you.");
	Stage.line();
	System.out.println("Please input a value from A-E and 1-5. For example, B5.");
	System.out.println("Whether it helps you or not, the letter is the x-axis and the digit is the y-axis...");
	Stage.line();
	System.out.println("Find out where he is first!");
	Stage.line();
	
	boolean foundBeast = false; // Used for a while loop
	int guesses = 0; // Num of guesses the user makes

	this.location = this.setBeastPos(); // sets location (Letter, Dig)
	
	while (!foundBeast) {
	    System.out.print("Please make a guess:    ");
	    String input = this.sc.nextLine();
	    guesses ++; // increment guesses so the user knows his score
	    
	    if (input.equals(this.location)) {
		System.out.println("Congrats! You killed the beast in " + guesses + " tries. Now after scouring the area, you have found gold on the seafloor. You are now the richest man in the world!");
		Stage.line();
		System.out.println("You WIN! Great job!");
		foundBeast = true;
	    } // closes if statement
	    
	    else if (guesses >= 20) {
		System.out.println("Too bad you lose. The beast outsmarted you. The beast is dancing with your guesses. He is laughing like crazy ;)   ");
		System.out.println("The beast was hiding on " + this.location);
	        break;
	    } else {
		System.out.println("miss");
	    }
	    
	}
	
	return foundBeast;
    }

    private String setBeastPos() {
	int x = (int) ((Math.random() * 5)+1);
	int y = (int) ((Math.random() * 5)+1);
	String place = null;
	
	if (x == 1) { place = "A" + y; }
	else if (x == 2) { place = "B" + y; }
	else if (x == 3) { place = "C" + y; }
	else if (x == 4) { place = "D" + y; }
	else if (x == 5) { place = "E" + y; }

	return place;
	    
    } // closes method
    
} // closes class
