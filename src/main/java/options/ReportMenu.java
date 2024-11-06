package options;

import java.util.Scanner;

import program.App;

import tools.FromConsole;

public class ReportMenu {
    public static void reportMenu(Scanner scan) {
        int menuSelection = FromConsole.intPrompt("1: Renting checkouts. Find the total number of equipment items rented by a single member patron\n2: Popular item. Find the most popular item\n3: Popular Manufacturer. Find the most frequent equipment manufacturer in the database\n4: Popular Drone. Find the most used drone in the database\n5: Items checked out. Find the member who has rented out the most items and the total number of items they have rented out\n6: Equipment by Type of Equipment. Find the description (name) of equipment by type released before YEAR", scan);
    
        switch (menuSelection) {
            case 1:
                rentingCheckouts(scan);
                break;
            case 2:
                popularItem(scan);
                break;
            case 3:
                popularManufacturer(scan);
                break;
            case 4:
                popularDrone(scan);
                break;
            case 5:
                itemsCheckedOut(scan);
                break;
            case 6:
                equipmentByType(scan);
                break;
            default:
                break;
        }
    }

    public static void rentingCheckouts(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void popularItem(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void popularManufacturer(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void popularDrone(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void itemsCheckedOut(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void equipmentByType(Scanner scan) {
        // TODO Create PreparedStatement and call SQLTools to query database
    }
}
