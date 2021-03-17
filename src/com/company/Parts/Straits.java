package com.company.Parts;
import com.company.Story;
import com.company.Battle;
import java.util.Scanner;

public class Straits implements Stage{
    private String gameState;
    public Scanner sc;
    private Battle battle;

    public Straits() {
        this.gameState = null;
        this.sc = new Scanner(System.in);
	this.battle = new Battle();
    }

    public String run(Story st) {
	Stage.line();
        System.out.println("Straits of Magellan; October 24, 1522: After a long uneventful voyage from the West African Coast, feasting day and night on the food from the captured British ship THE UNICORN, you gaze at the treasure in its hold.");
        Stage.line();
        System.out.println("You are nearing the Straits of Magellan and have noticed the temperature drop. Now " +
                "everyone on deck wears lots of layers and even " + st.firstMate + ", who is known for being strong, " +
                "shivers as you stare mesmerized at the gold.");
        Stage.line();
        System.out.println("All of a sudden, " + st.crew[7] + " cries out, 'Land 'Ho!'");
        Stage.line();
        System.out.println("You run out on deck and look outside. It is very foggy. You wonder how " + st.crew[7] +
                " found land. You also wonder where Magellan's gold is located.");
        Stage.line();
        System.out.print("Then, out of the corner of your eye, you spot something green and shiny floating on the " +
                "surface of the ocean. Could it be the gold? Do you (a) approach it or (b) ignore it?       ");
        String choice = st.getChoice("approach it", "ignore it", "pass"); // Player chooses from TWO options

        if (choice.equals("approach it")) { this.gameState = this.approachSerpent(st); }
        else { this.gameState = this.ignoreSerpent(st); }

        return this.gameState;
    }

    private String approachSerpent(Story st) {
	// Just a bunch of if statements regarding player choices
	// Reports a win, loss, etc
	String result = "lose";
        Stage.line();
        System.out.println("'Steer towards that floating thing,' you tell " + st.firstMate + ". You are now about a " +
                "hundred meters from it. You realize that the fog covered up its immense size. From here it looks " +
                "like a ship, but there is something weird about it...");
        Stage.line();
        System.out.println("It seems to have scales...");
        Stage.line();
        System.out.println("Suddenly it moves. You realize that it is a living thing, maybe a giant fish, no, a " +
                "crocodile or iguana, no it is too cold for them to live here. What could it be?");
        Stage.line();
        System.out.println("Then it hits you...");
        Stage.line();
        System.out.println("What was the old man speaking of on the harbor? Could it be this giant beast?");
        Stage.line();
        System.out.println("All of a sudden it moves again. A head pops out of the harbor. 'Oh No!' you exclaim.");
        Stage.line();
        System.out.print("What will you do? Will you (a) give up on the expedition, (b) try to kill it, or (c) flee" +
                " the beast, but stay on course for the treasure?      ");
        String choice = st.getChoice("give up on the expedition", "try to kill it", "flee the beast, but stay on course for the treasure");
        if (choice.equals("give up on the expedition")) {
            Stage.line();
            System.out.println("'Mates, we're leavin'! We already have some treasure,' you tell everyone aboard.");
            Stage.line();
            System.out.println("'" + st.firstMate + " , WE'RE LEAVING NOW! GO!' you order.");
            Stage.line();
            if (st.firstMate.equals("Vera Brave")) {
                System.out.println("'Never! I'm gonna murder the beast,' she says. Then she punches you in the face " +
                        "and shoves you making you fall near the edge of the boat.");
                Stage.line();
                System.out.println("'Haha, never trust a pirate! Especially me!' says Vera. Then she kicks you " +
                        "overboard.");
                Stage.line();
                System.out.println("You fall into the water. You struggle to gasp for air. It is useless...");
                Stage.line();
                System.out.println("The last thing you see is the" + st.ship + "sailing by, with " + st.firstMate +
                        " as captain. Her words resonate in your head. NEVER TRUST A PIRATE. NEVER TRUST A PIRATE...");
		        result = "lose";
            } else {
                System.out.println("When you arrive in European waters, a British ship captures '" + st.ship + "'");
		        result = "England";
            }
        } else if (choice.equals("try to kill it")) {
            Stage.line();
            System.out.println("'Men! Open up the cannons! READY... AIM... FIRE...' you yell to your men.");
            Stage.line();
            System.out.println("The cannonballs hit against the beast's scales. The beast growls and raises its head " +
                    "into the air.");
	    Stage.line();
	    System.out.println("The beast charges towards you. Now you see its entire green scaled body. It knocks against your ship. You stagger from the blow, and fall the the ground.");
	    Stage.line();
	    System.out.println("Another violent shock brings you to the edge of the boat. Your legs dangle from the ships edge. You hang from the strength of your arms and fingertips.");
	    Stage.line();
	    System.out.println("You feel your hands slipping on the wet wooden ship. Below you the beast opens its mouth wide.");
	    Stage.line();
	    System.out.println("Then you slip...");
	    result = "lose";
        } else {
	    Stage.line();
	    System.out.println("You order " + st.firstMate + " to turn the ship around and move away from the beast.");
	    this.ignoreSerpent(st);
	    result = "continue";
        }
        return result;
    }
    private String ignoreSerpent(Story st) {
	String result = "lose";
        Stage.line();
	System.out.println("Moving away from the floating thing in the water, worried that it is a beast, your ship leaves the area.");
	Stage.line();
	System.out.println("Then, all of a sudden, an earthquake-like thing happens. Giant waves emerge and crash onto your ship.");
	Stage.line();
	System.out.println("A huge serpent emerges from the water. Its emerald scales glisten in the pale sunshine. It thunders in a loud voice:");
	Stage.line();
	System.out.println("     'WHO DARES APPROACH MY LAIR! AH, YOU ARE PIRATES LOOKING FOR MAGELLAN'S TREASURE AREN'T YOU?'");
	Stage.line();
	System.out.println("     'WELL, I MADE MAGELLAN DIE IN THE PHILIPPINES. HE ANNOYED ME SO I CURSED HIM TO DEATH. YOU MIGHT GET THE SAME PUNISHMENT.'");
	Stage.line();
	System.out.println("With that he lowers his entire body into the water and says tauntingly, 'TRY TO GET ME'");
	Stage.line();
	System.out.println("Being the proud pirate that you are, you play his 'Little Game.'");
	Stage.line();
	if (this.battle.run()) { result = "win"; }
	else { result = "lose"; }
        return result;
    }


}
