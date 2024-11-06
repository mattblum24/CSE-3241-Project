package tools;

import java.util.Scanner;

public class FromConsole {
    
    public static String stringPrompt(String prompt, Scanner scan) {
        System.out.println(prompt);
        return scan.nextLine();
    }

    public static int intPrompt(String prompt, Scanner scan) {
        System.out.println(prompt);
        int result = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        return result;
    }

    public static boolean yesOrNo(String prompt, Scanner scan) {
        System.out.println(prompt);
        String response = scan.nextLine();
        return response.equals("yes");
    }

}
