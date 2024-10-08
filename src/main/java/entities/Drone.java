package entities;

public class Drone {
    
    String serialNumber;

    String name;

    String model;

    String status;

    String year;

    String weight;

    String capacity;

    String distanceAutonomy;

    String maxSpeed;

    String warrantyExpiration;

    String warehousePhone;

    String manufacturerPhone;
    
    String insurancePhone;

    public Drone(String name, String model, String serialNumber, String status, String year, String weight, String capacity, String distanceAutonomy, String maxSpeed, String warrantyExpiration, String warehousePhone, String manufacturerPhone, String insurancePhone) {
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
        this.year = year;
        this.weight = weight;
        this.capacity = capacity;
        this.distanceAutonomy = distanceAutonomy;
        this.maxSpeed = maxSpeed;
        this.warrantyExpiration = warrantyExpiration;
        this.warehousePhone = warehousePhone;
        this.manufacturerPhone = manufacturerPhone;
        this.insurancePhone = insurancePhone;
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

    // Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Year
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    // Weight
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    // Capacity
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    // Distance Autonomy
    public String getDistanceAutonomy() {
        return distanceAutonomy;
    }

    public void setDistanceAutonomy(String distanceAutonomy) {
        this.distanceAutonomy = distanceAutonomy;
    }

    // Max Speed
    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
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

    // Insurance Phone
    public String getInsurancePhone() {
        return insurancePhone;
    }

    public void setInsurancePhone(String insurancePhone) {
        this.insurancePhone = insurancePhone;
    }
}