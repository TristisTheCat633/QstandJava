package QStandProject;

public interface TaxiQueue {

    void toggleAvailability() throws QueueManagerExceptions;

    void confirmBooking(String bookingID) throws QueueManagerExceptions;

    void rejectBooking(String bookingID) throws QueueManagerExceptions;

    void cancelCurrentBooking(String bookingID) throws QueueManagerExceptions;
}
