package com.company.Parts;
import com.company.Story;
import java.util.Scanner;

public class England implements Stage{
    private Scanner sc;
    public String gameState;

    public England() {
        this.sc = new Scanner(System.in);
        this.gameState = null;
    }

    public String run(Story st) {
        // Everything that happens in this state in the game
        System.out.println("Two Weeks Later: England.");
        Stage.line();
        System.out.println("You are thrown in a jail, and are to be tried for murder, robbery, defying British " +
                "military, attempt of thievery.");
        Stage.line();
        System.out.println("You know that you will be hung. The crimes are nearly endless as stated in the trial. " +
                "None of your crew is here to save you.");
        Stage.line();
        System.out.println(" They abandoned you during the fight. Curse " + st.firstMate + " and your crew! You knew " +
                "that they shouldn't have been trusted.");
        Stage.line();
        System.out.println("After all they are pirates, aren't they? You suddenly want to get out and search for the " +
                "treasure more than ever.");
        Stage.line();
        System.out.print("Do you (a) Allow yourself to be hung, (b) Somehow escape prison, or (c) Beg for mercy     ");
        Stage.line();
        // All of the choices below lead to death
        // Basically if the player is in England, he/she will die
        String choice = st.getChoice("Allow yourself to be hung", "Somehow escape prison", "Beg for mercy");
        if (choice.equals("Allow yourself to be hung")) {
            this.gameState = this.hang();
        } else if (choice.equals("Beg for mercy")) {
            this.gameState = this.beg(st);
        } else {
            this.gameState = this.escape(st);
        }
        System.out.println("Too bad for you, you realize. The last thing you see is the world going blurry and then.." +
                ". darkness.");
        return this.gameState;
    }

    private String beg(Story st) {
        Stage.line();
        System.out.print("The next day, the execution date, when the jailer and captain of the ship walk in, you " +
                "beg for mercy. What do you say? (a) 'Please. Have mercy on me', (b) 'Please, don't kill me. I will " +
                "be your slave for the rest of my life', or (c) 'No. Please. I will redeem myself in the army'     ");
        String choice = st.getChoice("Please. Have mercy on me", "Please, don't kill me. I will be your slave for the rest of my life", "No. Please. I will redeem myself in the army");
        if (choice.equals("Please. Have mercy on me")) {
            System.out.println("'Haha, you really thing begging will help. Your crimes are too horrible to be set free" +
                    ". Your punishment remains,' the captain says.");
        } else {
            System.out.println("'Even becoming a slave or helping us is no repayment for you sins. Your punishment " +
                    "remains. You will be hung today,' the captain sneers");
        }
        return "lose";
    }
    private String escape(Story st) {
        System.out.println("You look around the prison cell. You might be able to break out through the bars, but you" +
                " only have a single day before the hanging.");
        Stage.line();
        System.out.println("Suddenly the captain walks in and says, 'You are to be killed today before a firing squad." +
                " You will suffer less. You should be happy.'");
        Stage.line();
        return "lose";
    }
    private String hang() {
        System.out.println("The jailer and the captain walk in smirking at you, 'Well, maybe you shouldn't have " +
                "pirated so much. Hope you go to hell tomorrow.' You sit down miserably; you will be publicly hung " +
                "tomorrow.");
        Stage.line();
        return "lose";
    }
}
