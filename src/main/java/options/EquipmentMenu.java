package options;

import java.util.HashMap;
import java.util.Scanner;

import entities.Equipment;
import tools.FromConsole;

public class EquipmentMenu {

    public static HashMap<String, Equipment> equipmentRepository = new HashMap<>();
    
    public static void equipmentMenu(Scanner scan) {
        int menuSelection = FromConsole.intPrompt("1: Add equipment\n2: Remove equipment\n3: List equipment\n4: Search equipment", scan);
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
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        String description = FromConsole.stringPrompt("Description: ", scan);
        String type = FromConsole.stringPrompt("Type: ", scan);
        String model = FromConsole.stringPrompt("Model: ", scan);
        String year = FromConsole.stringPrompt("Year: ", scan);
        String status = FromConsole.stringPrompt("Status: ", scan);
        String warrantyExpiration = FromConsole.stringPrompt("Warranty expiration: ", scan);
        String weight = FromConsole.stringPrompt("Weight: ", scan);
        String dimensions = FromConsole.stringPrompt("Dimensions: ", scan);
        String warehousePhone = FromConsole.stringPrompt("Warehouse phone: ", scan);
        String manufacturerPhone = FromConsole.stringPrompt("Manufacturer phone: ", scan);
        String insurancePhone = FromConsole.stringPrompt("Insurance phone: ", scan);
        
        Equipment equipment = new Equipment(serialNumber, description, type, model, year, status, warrantyExpiration, weight, dimensions, warehousePhone, manufacturerPhone, insurancePhone);

        equipmentRepository.put(serialNumber, equipment);
        System.out.println("Equipment added successfully");
    }

    public static void removeEquipment(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);

        equipmentRepository.remove(serialNumber);
        System.out.println("Equipment removed successfully");
    }

    public static void listEquipment() {
        for (Equipment equipment : equipmentRepository.values()) {
            System.out.println(equipment.getSerialNumber() + ": " + equipment.getDescription());
        }
    }

    public static void searchEquipment(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
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
}
