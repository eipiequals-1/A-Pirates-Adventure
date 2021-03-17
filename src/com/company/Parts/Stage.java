package com.company.Parts;
import com.company.Story;
import java.util.Scanner;

public interface Stage {

    String gameState = null;
    Scanner sc = new Scanner(System.in);
    String run(Story st);

    static void line() {
        // Allows the player to read one line at time using a Scanner object
        Scanner myScanner = new Scanner(System.in);
        String line = myScanner.nextLine();
    }
}
