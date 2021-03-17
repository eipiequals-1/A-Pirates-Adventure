package com.company;
import com.company.Parts.*;

import java.util.Scanner;

public class Story {
    // Public attributes of the player
    public String name;
    public String ship;
    public String firstMate;
    public String[] crew;
    
    // Create a reference variable to all important stages (objects) of the game
    private Part1 stage1;
    private Scanner sc;
    private Intro intro;
    private England england;
    private Straits strait;

    public Story() {
        // Initialize the references and link them to objects
        this.setCrew();
        this.sc = new Scanner(System.in); // User input object
        this.intro = new Intro();
        this.stage1 = new Part1();
        this.england = new England();
        this.strait = new Straits();
    }

    public void sequence() {
        // main loop for the story
        // handles important events and stages in the story
        boolean over = false;
        String currState = "continue"; // Stores game state in a String
        while (!over) {
            this.setName();
            this.setShip();
            this.intro.run(this);
            currState = this.stage1.run(this); // Stores new state in currState
	    
            if (currState.equals("continue") || currState.equals("win")) {
                currState = this.strait.run(this); // Continues in the Straits
		if (currState.equals("England")) {
		    currState = this.england.run(this);
		}
	    } else {
                currState = this.england.run(this);
	    } if (currState.equals("lose")) {
		over = true;
	    }
            over = true;
        }
    }

    private void setName() {
        // sets the player name
        System.out.print("What would you like to be called?      ");
        this.name = this.sc.nextLine();
    }

    private void setShip() {
        // sets the ship name
        System.out.print("Which ship would you prefer to sail on? The (a) 'Goldilocks,' (b) 'Treasure Trove,' or (c) 'Silverman's Chest'?      ");
        this.ship = this.getChoice("Goldilocks", "Treasure Trove", "Silverman's Chest");

    }
    public String getChoice(String optionA, String optionB, String optionC) {
        // Most important method to the game
        // Gets the user's input and returns an output which will decide future events
        String option = this.sc.nextLine();
        String returnedValue = null;
        boolean chosen = false;
        while (!chosen) {
            switch (option) {
                case "a":
                    returnedValue = optionA;
                    chosen = true;
                    break;
                case "b":
                    returnedValue = optionB;
                    chosen = true;
                    break;
                case "c":
                    returnedValue = optionC;
                    chosen = true;
                    break;
                default:
                    System.out.println("Please select a valid letter (a / b / c)"); // if user types an incorrect input
                    option = this.sc.nextLine();
                    break;
            }
        }
        return returnedValue; // returns user's choice
    }
    private void setCrew() {
        // Array of members, nothing more
        this.crew = new String[]{"Sir John Winters", "Vera Brave", "Big Jones", "Stinkin' Pete", "Old-tied Sammy",
                "Mad Michael", "Paddy Sparrow", "Celia 'Butcher' Tyde"};
    }

    public void manageCrew() { // public because the intro class wants to access it
        // Creates first mate
        // Introduces crew and begins the voyage
        System.out.print("You find three reckless and powerful pirates on the Portugese harbor. Who do you want as your first mate?  (a) " + this.crew[0] + ", (b) " + this.crew[1] + ", or (c) " + this.crew[3] + "   ");
	
        this.firstMate = this.getChoice(this.crew[0], this.crew[1], this.crew[3]);
        if (this.firstMate.equals(this.crew[0]) || this.firstMate.equals(this.crew[3])) {
            System.out.println(this.firstMate + " is a reliable pirate. He has looted hundreds of ships and is a very powerful pirate.");
        } else {
            System.out.println("Watch out! " + this.firstMate + " is very deceitful. Make sure she does not replace you as captain and KILL YOU...");
        }
        Stage.line();
        System.out.print("This will be a very long voyage. You are leaving tomorrow for the Straits of Magellan with " +
                "the crew. The members of your ship are ");
        for (String member: this.crew) {
            System.out.print(member + ", ");
        }
    }
}
