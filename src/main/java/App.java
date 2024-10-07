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
   
    // main menu
    public static int mainMenu(Scanner scan) {
        System.out.println("Type 1 to see previous orders, type 2 to see available equipment to rent or type 3 to exit: ");
        int input = scan.nextInt();
        return input;

    }

    // previous orders menu
    public static void previousOrders(Scanner scan) {
        System.out.println("Would you like to review? (yes or no)");
        String review = scan.nextLine();
        if(review == "yes") {
               System.out.println("Which order number would you like to leave a review for?");
               int orderNumber = scan.nextInt();
               String str = "Review for order %d: ";
               String strOutput = String.format(str, orderNumber);
               System.out.println(strOutput);
               String userReview = scan.nextLine();
        }


    }

    // avaliable equipment menu
    public static void avaliableEquipment(Scanner scan) {
        System.out.println("Would you like to rent a piece of equipment? (yes or no)");
        String enter = scan.nextLine();
        if(enter == "yes") {
            System.out.println("Type in the serial number for piece of equipment you would like to rent: ");
            int serialNumber = scan.nextInt();
            if(serialNumber > 0) {
                System.out.println("Thanks for your order! The estimated arrival is ______"); 
            }
        } 
    };

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");
        System.out.println("Do you have an account? (yes or no)");
        String yesOrNo = scan.nextLine();
        loginOrSignup(scan, yesOrNo);
        int menu = mainMenu(scan);        
        while(menu < 3) {
            switch (menu) {
                case 1:
                    previousOrders(scan);
                    break;
                
                case 2:
                    avaliableEquipment(scan);
                    break;

                default:
                    break;
            }
            menu = mainMenu(scan);
        }
        System.out.println("Thank you for visiting ___ rentals! Hope to see you again soon!");
        scan.close();
    }
}
