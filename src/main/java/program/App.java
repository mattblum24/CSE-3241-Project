package program;

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
        String url = "jdbc:sqlite:project";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Runs the login menu
    public static String customerIDSpecification(Scanner scan) {
        String customerId = FromConsole.stringPrompt("Enter customer ID: ", scan);
        return customerId;
    }

    public static void main(String[] args) throws Exception {
        initializeConnection();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");

        String customerId = customerIDSpecification(scan);

        boolean keepGoing = true;
        int menuSelection;
        while(keepGoing) {
            menuSelection = FromConsole.intPrompt("1: Rent equipment\n2: Return equipment\n3: Assign drone to delivery\n4: Assign drone to pickup\n5: Equipment menu\n6: Drone menu\n7: Report Menu\n8: Exit", scan);
            switch (menuSelection) {
                case 1:
                    FunctionOptions.rentEquipment(customerId, scan);
                    break;
                case 2:
                    FunctionOptions.returnEquipment(customerId, scan);
                    break;
                case 3: 
                    FunctionOptions.assignDroneToDelivery(customerId, scan);
                    break;
                case 4:
                    FunctionOptions.assignDroneToPickup(customerId, scan);
                    break;
                case 5:
                    EquipmentMenu.equipmentMenu(scan);
                    break;
                case 6:
                    DroneMenu.droneMenu(scan);
                    break;
                case 7:
                    ReportMenu.reportMenu(scan);
                    break;
                default:
                    keepGoing = false;
                    break;
            }
        }

        System.out.println("Thank you for visiting ___ Rentals! Hope to see you again soon!");
        scan.close();
        conn.close();
    }
}