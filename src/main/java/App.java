import java.util.Scanner;
import tools.FromConsole;

import java.sql.*;
import options.FunctionOptions;
import options.EquipmentMenu;
import options.DroneMenu;
import options.ReportMenu;

public class App {

    public static Connection conn = null;

    public static void initializeConnection() {
        String url = "jdbc:sqlite:project.db";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Runs the login menu
    public static String customerLoginOrSignup(Scanner scan) {
        boolean accountBool = FromConsole.yesOrNo("Do you have an account? (yes or no)", scan);

        String email;

        if(accountBool) {
            email = FromConsole.stringPrompt("Email: ", scan);
            //Future: Check database for valid email and handle logic
        } else {
            email = FromConsole.stringPrompt("Email: ", scan);
            String firstName = FromConsole.stringPrompt("First name: ", scan);
            String lastName = FromConsole.stringPrompt("Last name: ", scan);
            String address = FromConsole.stringPrompt("Address: ", scan);
            String phone = FromConsole.stringPrompt("Phone: ", scan);
            //Future: Add user to database with fields
            //Future: Will we allow users to create their own accounts? Or will this add extra work for ourselves?
        }

        return email;
    }

    public static void main(String[] args) throws Exception {
        initializeConnection();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");

        String customerEmail = customerLoginOrSignup(scan);
        String customerId = ""; //Future: Get customer ID from database

        boolean keepGoing = true;
        int menuSelection;
        while(keepGoing) {
            menuSelection = FromConsole.intPrompt("1: Rent equipment\n2: Return equipment\n3: Assign drone to delivery\n4: Assign drone to pickup\n5: Equipment menu\n6: Drone menu\n7: Report Menu\n8: Exit", scan);
            switch (menuSelection) {
                case 1:
                    FunctionOptions.rentEquipment(customerId, scan, conn);
                    break;
                case 2:
                    FunctionOptions.returnEquipment(customerId, scan, conn);
                    break;
                case 3: 
                    FunctionOptions.assignDroneToDelivery(customerId, scan, conn);
                    break;
                case 4:
                    FunctionOptions.assignDroneToPickup(customerId, scan, conn);
                    break;
                case 5:
                    EquipmentMenu.equipmentMenu(scan);
                    break;
                case 6:
                    DroneMenu.droneMenu(scan, conn);
                    break;
                case 7:
                    ReportMenu.reportMenu(scan, conn);
                    break;
                default:
                    keepGoing = false;
                    break;
            }
        }

        System.out.println("Thank you for visiting ___ Rentals! Hope to see you again soon!");
        scan.close();
    }
}