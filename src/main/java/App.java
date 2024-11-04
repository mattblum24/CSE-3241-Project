import java.util.Scanner;
import entities.Drone;
import entities.Equipment;
import java.util.HashMap;
import java.sql.*;

public class App {

    static HashMap<String, Equipment> equipmentRepository = new HashMap<>();
    static HashMap<String, Drone> droneRepository = new HashMap<>();

    public static String stringPromptFromConsole(String prompt, Scanner scan) {
        System.out.println(prompt);
        return scan.nextLine();
    }

    public static int intPromptFromConsole(String prompt, Scanner scan) {
        System.out.println(prompt);
        int result = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        return result;
    }

    public static boolean yesOrNoFromConsole(String prompt, Scanner scan) {
        System.out.println(prompt);
        String response = scan.nextLine();
        return response.equals("yes");
    }
    
    // Runs the login menu
    public static String customerLoginOrSignup(Scanner scan) {
        boolean accountBool = yesOrNoFromConsole("Do you have an account? (yes or no)", scan);

        String email;

        if(accountBool) {
            email = stringPromptFromConsole("Email: ", scan);
            //Future: Check database for valid email and handle logic
        } else {
            email = stringPromptFromConsole("Email: ", scan);
            String firstName = stringPromptFromConsole("First name: ", scan);
            String lastName = stringPromptFromConsole("Last name: ", scan);
            String address = stringPromptFromConsole("Address: ", scan);
            String phone = stringPromptFromConsole("Phone: ", scan);
            //Future: Add user to database with fields
            //Future: Will we allow users to create their own accounts? Or will this add extra work for ourselves?
        }

        return email;
    }

    // Rent equipment menu
    public static void rentEquipment(String customerId, Scanner scan, Connection conn) {
        String checkout = stringPromptFromConsole("Check out date (MM/DD/YYYY): ", scan);
        String dueDate = stringPromptFromConsole("Due date (MM/DD/YYYY): ", scan);
        String rentalFees = stringPromptFromConsole("Rental fees: ", scan);
        String serialNumber = stringPromptFromConsole("Equipment serial number: ", scan);
        MenuOptionsSQL.rentEquipment(customerId, checkout, dueDate, rentalFees, serialNumber, conn);
        System.out.println("Equipment rented successfully");
    }

    public static void returnEquipment(String customerId, Scanner scan, Connection conn) {
        String returnDate = stringPromptFromConsole("Return date (MM/DD/YYYY): ", scan);
        MenuOptionsSQL.returnEquipment(customerId, returnDate, conn);
        System.out.println("Equipment returned successfully");
    }

    public static void assignDroneToDelivery(String customerId, Scanner scan, Connection conn) {
        String droneId = stringPromptFromConsole("Drone Serial Number: ", scan);
        MenuOptionsSQL.assignDroneToDelivery(customerId, droneId, conn);
        System.out.println("Drone assigned to delivery successfully");
    }

    public static void assignDroneToPickup(String customerId, Scanner scan, Connection conn) {
        String droneId = stringPromptFromConsole("Drone Serial Number: ", scan);
        MenuOptionsSQL.assignDroneToPickup(customerId, droneId, conn);
        System.out.println("Drone assigned to pickup successfully");
    }

    public static void equipmentMenu(Scanner scan) {
        int menuSelection = intPromptFromConsole("1: Add equipment\n2: Remove equipment\n3: List equipment\n4: Search equipment", scan);
        switch (menuSelection) {
            case 1:
                addEquipment(scan);
                break;
            case 2:
                removeEquipment(scan);
                break;
            case 3:
                listEquipment();
                break;
            case 4:
                searchEquipment(scan);
                break;
            default:
                break;
        }
    }

    public static void addEquipment(Scanner scan) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);
        String description = stringPromptFromConsole("Description: ", scan);
        String type = stringPromptFromConsole("Type: ", scan);
        String model = stringPromptFromConsole("Model: ", scan);
        String year = stringPromptFromConsole("Year: ", scan);
        String status = stringPromptFromConsole("Status: ", scan);
        String warrantyExpiration = stringPromptFromConsole("Warranty expiration: ", scan);
        String weight = stringPromptFromConsole("Weight: ", scan);
        String dimensions = stringPromptFromConsole("Dimensions: ", scan);
        String warehousePhone = stringPromptFromConsole("Warehouse phone: ", scan);
        String manufacturerPhone = stringPromptFromConsole("Manufacturer phone: ", scan);
        String insurancePhone = stringPromptFromConsole("Insurance phone: ", scan);
        
        Equipment equipment = new Equipment(serialNumber, description, type, model, year, status, warrantyExpiration, weight, dimensions, warehousePhone, manufacturerPhone, insurancePhone);

        equipmentRepository.put(serialNumber, equipment);
        System.out.println("Equipment added successfully");
    }

    public static void removeEquipment(Scanner scan) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);

        equipmentRepository.remove(serialNumber);
        System.out.println("Equipment removed successfully");
    }

    public static void listEquipment() {
        for (Equipment equipment : equipmentRepository.values()) {
            System.out.println(equipment.getSerialNumber() + ": " + equipment.getDescription());
        }
    }

    public static void searchEquipment(Scanner scan) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);
        Equipment equipment = equipmentRepository.get(serialNumber);
        System.out.println("Description: " + equipment.getDescription());
        System.out.println("Type: " + equipment.getType());
        System.out.println("Model: " + equipment.getModel());
        System.out.println("Year: " + equipment.getYear());
        System.out.println("Status: " + equipment.getStatus());
        System.out.println("Warranty expiration: " + equipment.getWarrantyExpiration());
        System.out.println("Weight: " + equipment.getWeight());
        System.out.println("Dimensions: " + equipment.getDimensions());
        System.out.println("Warehouse phone: " + equipment.getWarehousePhone());
        System.out.println("Manufacturer phone: " + equipment.getManufacturerPhone());
        System.out.println("Insurance phone: " + equipment.getInsurancePhone());
    }

    public static void droneMenu(Scanner scan,  Connection conn) {
        int menuSelection = intPromptFromConsole("1: Add drone\n2: Remove drone\n3: List drones\n4: Search drones", scan);
        switch (menuSelection) {
            case 1:
                addDrone(scan, conn);
                break;
            case 2:
                removeDrone(scan, conn);
                break;
            case 3:
                listDrones(conn);
                break;
            case 4:
                searchDrones(scan, conn);
                break;
            default:
                break;
        }
    }

    public static void addDrone(Scanner scan, Connection conn) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);
        String name = stringPromptFromConsole("Name: ", scan);
        String model = stringPromptFromConsole("Model: ", scan);
        int status = intPromptFromConsole("Status: ", scan);
        String year = stringPromptFromConsole("Year: ", scan);
        String warrantyExpiration = stringPromptFromConsole("Warranty expiration: ", scan);
        int availability = intPromptFromConsole("Availability: ", scan);
        String warehousePhone = stringPromptFromConsole("Warehouse phone: ", scan);
        String manufacturerPhone = stringPromptFromConsole("Manufacturer phone: ", scan);

        Drone drone = new Drone(serialNumber, name, model, status, year, warrantyExpiration, availability, warehousePhone, manufacturerPhone);

        droneRepository.put(serialNumber, drone);
        System.out.println("Drone added successfully");
    }

    public static void removeDrone(Scanner scan, Connection conn) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);

        droneRepository.remove(serialNumber);
        System.out.println("Drone removed successfully");
    }

    public static void listDrones(Connection conn) {
        for (Drone drone : droneRepository.values()) {
            System.out.println(drone.getSerialNumber() + ": " + drone.getName());
        }
    }

    public static void searchDrones(Scanner scan, Connection conn) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);
        Drone drone = droneRepository.get(serialNumber);
        System.out.println("Name: " + drone.getName());
        System.out.println("Model: " + drone.getModel());
        System.out.println("Status: " + Integer.toString(drone.getStatus()));
        System.out.println("Year: " + drone.getYear());
        System.out.println("Warranty expiration: " + drone.getWarrantyExpiration());
        System.out.println("Availability: " + Integer.toString(drone.getAvailability()));
        System.out.println("Warehouse phone: " + drone.getWarehousePhone());
        System.out.println("Manufacturer phone: " + drone.getManufacturerPhone());
    }

    public static void reportMenu(Scanner scan, Connection conn) {
        int menuSelection = intPromptFromConsole("1: Renting checkouts. Find the total number of equipment items rented by a single member patron\n2: Popular item. Find the most popular item\n3: Popular Manufacturer. Find the most frequent equipment manufacturer in the database\n4: Popular Drone. Find the most used drone in the database\n5: Items checked out. Find the member who has rented out the most items and the total number of items they have rented out\n6: Equipment by Type of Equipment. Find the description (name) of equipment by type released before YEAR", scan);
    
        switch (menuSelection) {
            case 1:
                rentingCheckouts(scan, conn);
                break;
            case 2:
                popularItem(scan, conn);
                break;
            case 3:
                popularManufacturer(scan, conn);
                break;
            case 4:
                popularDrone(scan, conn);
                break;
            case 5:
                itemsCheckedOut(scan, conn);
                break;
            case 6:
                equipmentByType(scan, conn);
                break;
            default:
                break;
        }
    }

    public static void rentingCheckouts(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.rentingCheckouts(conn);
        // TODO: Print out the results
    }

    public static void popularItem(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.popularItem(conn);
        // TODO: Print out the results
    }

    public static void popularManufacturer(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.popularManufacturer(conn);
        // TODO: Print out the results
    }

    public static void popularDrone(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.popularDrone(conn);
        // TODO: Print out the results
    }

    public static void itemsCheckedOut(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.itemsCheckedOut(conn);
        // TODO: Print out the results
    }

    public static void equipmentByType(Scanner scan, Connection conn) {
        ResultSet rs = ReportsSQL.equipmentByType(conn);
        // TODO: Print out the results
    }

    public static void main(String[] args) throws Exception {
        final String JDBC_DRIVER = "UPDATE";
        final String DB_URL = "UPDATE";
        final String USER = "UPDATE";
        final String PASS = "UPDATE";

        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");

        String customerEmail = customerLoginOrSignup(scan);
        String customerId = ""; //TODO: Get customer ID from database by email

        boolean keepGoing = true;
        int menuSelection;
        while(keepGoing) {
            menuSelection = intPromptFromConsole("1: Rent equipment\n2: Return equipment\n3: Assign drone to delivery\n4: Assign drone to pickup\n5: Equipment menu\n6: Drone menu\n7: Report Menu\n8: Exit", scan);
            switch (menuSelection) {
                case 1:
                    rentEquipment(customerId, scan, conn);
                    break;
                case 2:
                    returnEquipment(customerId, scan, conn);
                    break;
                case 3: 
                    assignDroneToDelivery(customerId, scan, conn);
                    break;
                case 4:
                    assignDroneToPickup(customerId, scan, conn);
                    break;
                case 5:
                    equipmentMenu(scan);
                    break;
                case 6:
                    droneMenu(scan, conn);
                    break;
                case 7:
                    reportMenu(scan, conn);
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