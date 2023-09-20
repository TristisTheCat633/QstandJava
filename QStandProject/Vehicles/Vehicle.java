package QStandProject;

public abstract class Vehicle {

    private int size;
    private String vehicleNumber;
    private boolean isAvailable;
    public Vehicle(int size, String vehicleNumber) {
        this.size = size;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}


