package QStandProject;

public class Van extends Vehicle implements TaxiQueue {

    private String[] vanSchedule;
    
    public Van(int vehicleSize, String vehicleID) {
        super(vehicleSize, vehicleID);
        this.vanSchedule = new String[]{"9AM", "11AM", "1PM", "3PM", "5PM", "7PM", "9PM"};
    }


    public void toggleAvailability() {
        this.setIsAvailable(!this.getIsAvailable());
    }

    public void confirmBooking(String bookingID) {
        if (this.getIsAvailable()) {
            this.setIsAvailable(false);
            System.out.println("Van booking confirmed with Booking ID: " + bookingID);
        } else {
            System.out.println("This van is already booked.");
        }
    }
    
    public void rejectBooking(String bookingID) {
        System.out.println("Van " + " has rejected booking with ID: " + bookingID);
    }


    public void cancelCurrentBooking(String bookingID) {
        if (!getIsAvailable()) {
            System.out.println("Van " +  " has canceled booking for ID: " + bookingID);
            toggleAvailability();
        } else {
            System.out.println("No active booking to cancel for Van ");
        }
    }

    public boolean isTimeSlotAvailable(String timeSlot) {
        for (String slot : vanSchedule) {
            if (slot != null && slot.equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
    
    
    public void bookTimeSlot(String timeSlot) {
        for (int i = 0; i < vanSchedule.length; i++) {
            if (vanSchedule[i] == null) {
                vanSchedule[i] = timeSlot;
                break;
            }
        }
    }
    
    public String toString() {
        return "Van - ID: " + getVehicleNumber();
    }
}

