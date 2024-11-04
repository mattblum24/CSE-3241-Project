package entities;

public class Drone {
    
    String serialNumber;

    String name;

    String model;

    int status;

    String year;

    String warrantyExpiration;

    int availability;

    String warehousePhone;

    String manufacturerPhone;
    
    public Drone(String name, String model, String serialNumber, int status, String year, String warrantyExpiration, int availability, String warehousePhone, String manufacturerPhone) {
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
        this.year = year;
        this.warrantyExpiration = warrantyExpiration;
        this.warehousePhone = warehousePhone;
        this.manufacturerPhone = manufacturerPhone;
        this.availability = availability;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Serial Number
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    // Year
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    // Warranty Expiration
    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    // Warehouse Phone
    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    // Manufacturer Phone
    public String getManufacturerPhone() {
        return manufacturerPhone;
    }

    public void setManufacturerPhone(String manufacturerPhone) {
        this.manufacturerPhone = manufacturerPhone;
    }

    // Availability
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    // Status
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}