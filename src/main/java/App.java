import java.util.Scanner;
import entities.Drone;
import entities.Equipment;
import java.util.HashMap;

public class App {

    HashMap<String, Equipment> equipmentRepository = new HashMap<>();
    HashMap<String, Drone> droneRepository = new HashMap<>();
    
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
        return scan.nextLine();
    }

    // Gathers the password from the user
    public static String loginPassword(Scanner scan) {
        System.out.println("Password: ");
        return scan.nextLine();
    }

    // Gathers the email from the user
    public static String signupEmail(Scanner scan) {
        System.out.println("Email: ");
        return scan.nextLine();
    }
    
    // Gathers the phone number from the user
    public static String signupPhoneNumber(Scanner scan) {
        System.out.println("Phone Number: ");
        return scan.nextLine();
    }
   
    // Main menu
    public static int mainMenu(Scanner scan) {
        System.out.println("Type 1 to see previous orders, type 2 to see available equipment to rent or type 3 to exit: ");
        if(!scan.hasNextInt()) {
            scan.next(); // Discard invalid input
            return 3;
        }
        return scan.nextInt();
    }

    // Previous orders menu
    public static void previousOrders(Scanner scan) {
        System.out.println("Which order number would you like to leave a review for?");
        int orderNumber = scan.nextInt();
        scan.nextLine(); // Consume newline left-over
        String str = "Review for order %d: ";
        System.out.printf(str, orderNumber);
        String userReview = scan.nextLine();
        System.out.println("Thank you for your review!");
    }

    // Available equipment menu
    public static void availableEquipment(Scanner scan) {
        System.out.println("Type in the serial number for the piece of equipment you would like to rent: ");
        int serialNumber = scan.nextInt();
        if(serialNumber > 0) {
            System.out.println("Thanks for your order! The estimated arrival is ______");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");
        System.out.println("Do you have an account? (yes or no)");
        String yesOrNo = scan.nextLine();
        loginOrSignup(scan, yesOrNo);

        int menu = mainMenu(scan);
        scan.nextLine(); // Consume newline

        while(menu < 3) {
            if(menu == 1) {
                System.out.println("Would you like to review? (yes or no)");
                String review = scan.nextLine();
                if(review.equals("yes")) {
                    previousOrders(scan);
                }
            } else if(menu == 2) {
                System.out.println("Would you like to rent a piece of equipment? (yes or no)");
                String enter = scan.nextLine();
                if(enter.equals("yes")) {
                    availableEquipment(scan);
                }
            }
            menu = mainMenu(scan);
            scan.nextLine(); // Consume newline left-over
        }
        System.out.println("Thank you for visiting ___ Rentals! Hope to see you again soon!");
        scan.close();
    }
}