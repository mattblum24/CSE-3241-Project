import java.util.Scanner;
import entities.Drone;
import entities.Equipment;
import java.util.HashMap;

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
            //TODO: Check database for valid email and handle logic
        } else {
            email = stringPromptFromConsole("Email: ", scan);
            String firstName = stringPromptFromConsole("First name: ", scan);
            String lastName = stringPromptFromConsole("Last name: ", scan);
            String address = stringPromptFromConsole("Address: ", scan);
            String phone = stringPromptFromConsole("Phone: ", scan);
            //TODO: Add user to database with fields
            //TODO: Will we allow users to create their own accounts? Or will this add extra work for ourselves?
        }

        return email;
    }

    // Rent equipment menu
    public static void rentEquipment(String customerId, Scanner scan) {
        String checkout = stringPromptFromConsole("Check out date (MM/DD/YYYY): ", scan);
        String dueDate = stringPromptFromConsole("Due date (MM/DD/YYYY): ", scan);
        String rentalFees = stringPromptFromConsole("Rental fees: ", scan);
        String serialNumber = stringPromptFromConsole("Equipment serial number: ", scan);
        // TODO: Check for valid serialNumber and add to rentals in database for customer
        System.out.println("Equipment rented successfully");
    }

    public static void returnEquipment(String customerId, Scanner scan) {
        String returnDate = stringPromptFromConsole("Return date (MM/DD/YYYY): ", scan);
        // TODO: Update rentals entry in database
        System.out.println("Equipment returned successfully");
    }

    public static void assignDroneToDelivery(String customerId, Scanner scan) {
        String droneId = stringPromptFromConsole("Drone ID: ", scan);
        // TODO: Check for valid droneId and assign to rental in database for customer
        System.out.println("Drone assigned to delivery successfully");
    }

    public static void assignDroneToPickup(String customerId, Scanner scan) {
        String droneId = stringPromptFromConsole("Drone ID: ", scan);
        // TODO: What do we do with this? There is nothing in the schema corresponding to this
        System.out.println("Drone assigned to pickup successfully");
    }

    public static void equipmentMenu(Scanner scan) {
        int menuSelection = intPromptFromConsole("1: Add equipment\n2: Remove equipment\n3: List equipment", scan);
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

    public static void droneMenu(Scanner scan) {
        int menuSelection = intPromptFromConsole("1: Add drone\n2: Remove drone\n3: List drones", scan);
        switch (menuSelection) {
            case 1:
                addDrone(scan);
                break;
            case 2:
                removeDrone(scan);
                break;
            case 3:
                listDrones();
                break;
            default:
                break;
        }
    }

    public static void addDrone(Scanner scan) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);
        String name = stringPromptFromConsole("Name: ", scan);
        String model = stringPromptFromConsole("Model: ", scan);
        String status = stringPromptFromConsole("Status: ", scan);
        String year = stringPromptFromConsole("Year: ", scan);
        String weight = stringPromptFromConsole("Weight: ", scan);
        String capacity = stringPromptFromConsole("Capacity: ", scan);
        String distanceAutonomy = stringPromptFromConsole("Distance autonomy: ", scan);
        String maxSpeed = stringPromptFromConsole("Max speed: ", scan);
        String warrantyExpiration = stringPromptFromConsole("Warranty expiration: ", scan);
        String warehousePhone = stringPromptFromConsole("Warehouse phone: ", scan);
        String manufacturerPhone = stringPromptFromConsole("Manufacturer phone: ", scan);
        String insurancePhone = stringPromptFromConsole("Insurance phone: ", scan);

        Drone drone = new Drone(serialNumber, name, model, status, year, weight, capacity, distanceAutonomy, maxSpeed, warrantyExpiration, warehousePhone, manufacturerPhone, insurancePhone);

        droneRepository.put(serialNumber, drone);
        System.out.println("Drone added successfully");
    }

    public static void removeDrone(Scanner scan) {
        String serialNumber = stringPromptFromConsole("Serial number: ", scan);

        droneRepository.remove(serialNumber);
        System.out.println("Drone removed successfully");
    }

    public static void listDrones() {
        for (Drone drone : droneRepository.values()) {
            System.out.println(drone.getSerialNumber() + ": " + drone.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to ___ Rentals!");

        String customerEmail = customerLoginOrSignup(scan);
        String customerId = ""; //TODO: Get customer ID from database by email

        boolean keepGoing = true;
        int menuSelection;
        while(keepGoing) {
            menuSelection = intPromptFromConsole("1: Rent equipment\n2: Return equipment\n3: Assign drone to delivery\n4: Assign drone to pickup\n5: Equipment menu\n6: Drone menu", scan);
            switch (menuSelection) {
                case 1:
                    rentEquipment(customerId, scan);
                    break;
                case 2:
                    returnEquipment(customerId, scan);
                    break;
                case 3: 
                    assignDroneToDelivery(customerId, scan);
                    break;
                case 4:
                    assignDroneToPickup(customerId, scan);
                    break;
                case 5:
                    equipmentMenu(scan);
                    break;
                case 6:
                    droneMenu(scan);
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