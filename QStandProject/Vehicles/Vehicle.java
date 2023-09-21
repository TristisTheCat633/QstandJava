package QStandProject;

public abstract class Vehicle {
    private boolean isAvailable;
    private String taxiNumber;
    private int seats;

    public Vehicle(int capacity, String taxiNumber) {
        if (!taxiNumber.matches("^[1-9][A-Z][0-9]{4}$")) {
            throw new IllegalArgumentException("Invalid Taxi Number format!");
        }
        this.seats = capacity;
        this.taxiNumber = taxiNumber;
    }
	
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getSeats() {
        return seats;
    }

    public String getVehicleNumber() {
        return taxiNumber;
    }
}