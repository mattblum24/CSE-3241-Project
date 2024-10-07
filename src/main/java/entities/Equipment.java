package entities;

public class Equipment {
    
    String description;

    String type;
    
    String model;

    String serialNumber;

    String status;

    String location;

    String warrantyExpiration;

    String weight;

    String dimensions;

    public Equipment(String description, String type, String model, String serialNumber, String status, String location, String warrantyExpiration, String weight, String dimensions) {
        this.description = description;
        this.type = type;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
        this.location = location;
        this.warrantyExpiration = warrantyExpiration;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

}
