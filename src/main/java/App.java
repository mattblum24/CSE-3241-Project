import java.util.Scanner;

public class App {
    
    // Runs the login menu
    public static void loginOrSignup(Scanner scan, String yesOrNo) {
        if(yesOrNo.equals("yes")) {
            String username = loginUsername(scan);
            String password = loginPassword(scan);
        } else {
            String username = loginUsername(scan);
            String password = loginPassword(scan); 
            String email = signupEmail(scan);
            String phoneNumber = signupPhoneNumber(scan);
        }
    }
    
    // Gathers the username from the user
    public static String loginUsername(Scanner scan) {
        System.out.println("Username: ");
        String username = scan.nextLine(); 
        return username;
    }

    // Gathers the password from the user
    public static String loginPassword(Scanner scan) {
        System.out.println("Password: ");
        String password = scan.nextLine();
        return password;
    }

    // Gathers the email from the user
    public static String signupEmail(Scanner scan) {
        System.out.println("Email: ");
        String email = scan.nextLine();
        return email;
    }
    
    // Gathers the phone number from the user
    public static String signupPhoneNumber(Scanner scan) {
        System.out.println("Phone Number: ");
        String phoneNumber = scan.nextLine();
        return phoneNumber;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");
        System.out.println("Do you have an account?");
        String yesOrNo = scan.nextLine();
        loginOrSignup(scan, yesOrNo);
        scan.close();
    }
}
