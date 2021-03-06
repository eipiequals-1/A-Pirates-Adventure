package com.company.Parts;
import com.company.Story;
import java.util.Scanner;

public class Part1 implements Stage {
    // Creates important objects reference variables
    private Scanner sc;
    public String gameState;

    public Part1() {
        this.sc = new Scanner(System.in); // User input object
        this.gameState = null; // Sets a default gameState value
    }

    public String run(Story st) {
        // Everything in this stage happens here
        System.out.println(st.ship + " will bring you a bounty of treasure with your hopefully good crew...");
        Stage.line(); // Allows the player to read one line at a time
        System.out.println("Well, good luck, you'll need it");
        Stage.line();
        System.out.println("September 13, 1522: You walk on the harbor, breathing in the fresh, salty air. There is a old, seafaring man who walks up to you, hobbling over his seemingly damaged leg. He speaks to you in a raspy voice... ");
        Stage.line();
        this.manageOldMan(st.name);
        System.out.println("Your crew arrive, and you are ready to leave Portugal aboard the " + st.ship + ".");
        Stage.line();
        System.out.println("You charge up onto the deck and scream orders to the crew. You draw your sword and thrust " +
                "it into the air. 'Let's go! All hands on deck,' you yell in a commanding tone.");
        Stage.line();
        System.out.println("By now, you are on open ocean and sit on deck hoping to not get distracted by looting " +
                "ships.");
        Stage.line();
        System.out.println("September 19, 1522:");
        System.out.println("On the morning of the 6th day at sea, when you are nearing the African Coast, all of a " +
                "sudden, you spot a British galleon heading towards you at 35 knots. You suddenly desire riches and want to attack the ship.");
        Stage.line();
        System.out.print("What will you do? (a) Attack the ship (b) Let the British attack your ship (c) Flee and " +
                "continue the mission?       ");
        String britChoice = st.getChoice("Attack the ship", "Let the British attack your ship", "Flee and continue the mission");
        // Choices made with the British
        if (britChoice.equals("Attack the ship")) {
            Stage.line();
            this.gameState = this.runAttackOnBrits(st);
        } else if (britChoice.equals("Let the British attack your ship")) {
            Stage.line();
            this.gameState = this.runBritAttack(st);
        } else {
            Stage.line();
            System.out.println("'Full speed for the Straits,' you yell to " + st.firstMate + ".");
            Stage.line();
            this.gameState = "continue";
        }
        return this.gameState;
    }


    private void manageOldMan(String name) {
        // Unimportant character but introduces some aspects of the adventure
        System.out.println("'H'y mate. You ain't goin' after Magellan's treasure, are ya?'");
        Stage.line();
        System.out.println("You say, 'Yes, why?' ");
        Stage.line();
        System.out.println("He slowly replied, 'Yehaw, you hav'n heard the tale? They say a great beast lurks in the " +
                "waters preying on pirates and loves gold. You watch yourself kid. Don't want to get caught by it.' " +
                "He slowly limps away.");
        Stage.line();
        System.out.println("'Well, I'm still goin' or I ain't a pirate and my name ain't Captain " + name + "', " +
                "You think to yourself.");
        Stage.line();
    }

    private String runBritAttack(Story st) {
        // What happens when the British attack the player
        System.out.println("'British ship in sight,' says " + st.crew[5] + " from the crow's nest.");
        Stage.line();
        System.out.println("You scream, 'Arr Mates. Attack! Shoot them.' Your men scramble to get their guns and " +
                "swords. Meanwhile, the British begin shooting your ship through their cannons. It burns through your" +
                " masts. You hear the violent crack of the destruction on your ship.");
        Stage.line();
        System.out.println("'Board their ship!' you yell to your crew. You jump aboard their ship and swing your " +
                "sword around, killing several British sailors. Grasping your three pointed hat, you find the passage" +
                " to the hold...");
        Stage.line();
        System.out.println("Sitting there waiting to be taken are thousands of pounds of gold. You immediately " +
                "realize that you need to take the ship to steal the gold. All of a sudden five members of the " +
                "British crew aim their guns at you.");
        Stage.line();
        System.out.print("'Hands up. We are taking you to England as prisoners,' says the captain as you raise your" +
                " hands in the air. Do you (a) fight back or (b) surrender?     ");
        String choice = st.getChoice("fight back", "surrender", "pass");
        if (choice.equals("fight back")) {
            Stage.line();
            System.out.println("Two sailors' guns are now inches from your face. In a sudden move, you grab both guns" +
                    " with your hands and raise them to the sky, causing the sailors to fire.");
            Stage.line();
            System.out.println("Then you punch the captain, who then falls to the ground, and draw your sword. You cut open the other members of the crew and charge up onto the deck.");
            Stage.line();
            System.out.println("Then you go on deck and yell to the world, 'Leave now, British scalawags. We have " +
                    "taken your ship. " + st.firstMate + " captures all the men and throws them into the water.'");
            return "win";
        } else {
            Stage.line();
            System.out.println("You curse at them maliciously, 'Damn you all to hell!'");
            return "England"; // The main player essentially returns to England for punishment
        }
    }

    private String runAttackOnBrits(Story st) {
        // What happens when the player attacks the British
        System.out.println("'British ship in sight,' says " + st.crew[5] + " from the crow's nest.");
        Stage.line();
        System.out.println("'Attack!' shouts " + st.firstMate + ". " + st.ship + " approaches them at a startling " +
                "speed. You yell to your men, 'Shoot them with all we got!'");
        Stage.line();
        System.out.println("Both boats are now a few meters away. With your first mate and " + st.crew[6] + ", you " +
                "swing onto the ship. With both of your pistols you shoot the British sailors.");
        Stage.line();
        System.out.print("You spot the captain cowering away near the steering wheel. Do you (a) take him on " +
                "by yourself, (b) get your crew to fight with you, or (c) force him to surrender?      ");
        Stage.line();
        String choice = st.getChoice("take him on by yourself", "get your crew to fight with you", "force him to surrender");
        if (choice.equals("take him on by yourself")) {
            Stage.line();
            System.out.println("You draw your sword and lunge at him. The captain begs for mercy. You decide to " +
                    "out of pity let the remaining British crew flee on a rowboat.");
            Stage.line();
            System.out.println("'Leave this ship, Brits! It is ours!' you boom through the British vessel. Immediately, the British begin jumping overboard; they are terrified. You drop them a rowboat");
            Stage.line();
        } else {
            Stage.line();
            System.out.println("'Come aboard, men,' you shout through the screams of the fight. Your crew swings aboard the British ship to join you. They take aim at the captain. BOOM. BAM. It is over for the captain...");
            Stage.line();
            System.out.println("'Leave this ship, Brits! It is ours!' you boom through the British vessel. Immediately, the British begin jumping overboard; they are terrified. You drop them a rowboat out of pity.");
        }
        return "win"; // Any situation above leads to a win
    }
}
