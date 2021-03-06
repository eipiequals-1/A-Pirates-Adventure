package com.company.Parts;
import com.company.Story;
import java.util.Scanner;

public class Intro implements Stage{
    private Scanner sc;
    public String gameState;

    public Intro() {
        this.sc = new Scanner(System.in);
        this.gameState = "continue";

    }

    public String run(Story st) {
        this.drawLogo();
        System.out.println("Welcome, Cap'n " + st.name + " to PIRATES OF THE SEVENTH SEA on the 5 masted " + st.ship.toUpperCase() + ".");
        Stage.line(); // A simple line that allows the reader to read one line at a time;
        System.out.println("Portugal, September 12, 1522: In the midst of the Age of Exploration, renowned explorer " +
                "Ferdinand Magellan's ship has returned from a circumnavigation of the globe.");
        Stage.line();
        System.out.println("But he was killed in the Philippines by a poisoned arrow. However, there is a treasure " +
                "that he has left on the southernmost tip of South America. It is said to contain billions of dollars" +
                " in gold...");
        Stage.line();
        System.out.println("Okay, you want that treasure, don't you? Well, now that you have bought " + st.ship + ", " +
                "you need a very reliable pirating crew. This means a boatload of pirates.");
        Stage.line();
        st.manageCrew(); // a public method that introduces the crew
        return this.gameState;
    }


    private void drawLogo() {
        System.out.println("            _____                              ");
        System.out.println("            |___|                              ");
        System.out.println("            ||            |                    ");
        System.out.println("            ||            /\\                  ");
        System.out.println("            ||            ||                   ");
        System.out.println("            __            __                   ");
        System.out.println("           \\  /          \\  /                ");
        System.out.println("            ||            ||                   ");
        System.out.println("            ||            ||                /  ");
        System.out.println("           /||            ||             /     ");
        System.out.println("   ()_()  / ||            ||          /        ");
        System.out.println("   |_|_| /  ||            ||       /           ");
        System.out.println("  |_|_|_|___||__          ||    /              ");
        System.out.println("   \\___/________|________||_/                 ");
        System.out.println("   /    \\  _  --           /                  ");
        System.out.println("  |      |         __ -   /                    ");
        System.out.println("   \\____/_______________ /                    ");
    }
}
