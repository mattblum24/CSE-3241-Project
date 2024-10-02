inport java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");
        System.out.println("Do you have an account?");
        String yesOrNo = scan.nextLine();
        if(yesOrNo = "yes") {
            System.out.println("Username: ");
            String username = scan.nextLine();
            System.out.println("Password: ");
            String password = scan.nextLine();
        } else {
            System.out.println("Username: ");
            String username = scan.nextLine();
            System.out.println("Password: ");
            String password = scan.nextLine();
            System.out.println("Email: ");
            String email = scan.nextLine();
            System.out.println("Phone Number: ");
            String phoneNumber = scan.nextLine();
        }
    }
}
