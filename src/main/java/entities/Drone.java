package entities;

public class Drone {
    
    String name;

    String model;

    String serialNumber;

    String status;

    String location;
    
    String year;

    String weightCapacity;

    String distanceAutonomy;

    String maxSpeed;

    String warrantyExpiration;

    public Drone(String name, String model, String serialNumber, String status, String location, String year, String weightCapacity, String distanceAutonomy, String maxSpeed, String warrantyExpiration) {
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
        this.location = location;
        this.year = year;
        this.weightCapacity = weightCapacity;
        this.distanceAutonomy = distanceAutonomy;
        this.maxSpeed = maxSpeed;
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(String weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public String getDistanceAutonomy() {
        return distanceAutonomy;
    }

    public void setDistanceAutonomy(String distanceAutonomy) {
        this.distanceAutonomy = distanceAutonomy;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

}
