package entities;

public class Equipment {

    String serialNumber;

    String description;

    String type;

    String model;

    String year;

    String status;

    String warrantyExpiration;

    String weight;

    String dimensions;

    String warehousePhone;

    String manufacturerPhone;
    
    String insurancePhone;

    public Equipment(String description, String type, String model, String serialNumber, String status, String location, String warrantyExpiration, String weight, String dimensions, String warehousePhone, String manufacturerPhone, String insurancePhone) {
        this.description = description;
        this.type = type;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
        this.warrantyExpiration = warrantyExpiration;
        this.weight = weight;
        this.dimensions = dimensions;
        this.warehousePhone = warehousePhone;
        this.manufacturerPhone = manufacturerPhone;
        this.insurancePhone = insurancePhone;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    // Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Warranty Expiration
    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    // Weight
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    // Dimensions
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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