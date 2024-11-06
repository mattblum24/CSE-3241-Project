package options;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import sql.ReportsSQL;
import tools.FromConsole;

public class ReportMenu {
    public static void reportMenu(Scanner scan, Connection conn) {
        int menuSelection = FromConsole.intPrompt("1: Renting checkouts. Find the total number of equipment items rented by a single member patron\n2: Popular item. Find the most popular item\n3: Popular Manufacturer. Find the most frequent equipment manufacturer in the database\n4: Popular Drone. Find the most used drone in the database\n5: Items checked out. Find the member who has rented out the most items and the total number of items they have rented out\n6: Equipment by Type of Equipment. Find the description (name) of equipment by type released before YEAR", scan);
    
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
}
