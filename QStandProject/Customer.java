package QStandProject;
import java.util.Random;
import java.util.Scanner;
public class Customer extends User {
   

    private String taxiType;
    private boolean activeBooking;
    private int bookingId;
    private Vehicle bookedTaxi;
    private Random rand = new Random();
    private boolean hasActiveBookingForRegularTaxi = false;
    private boolean hasActiveBookingForBigTaxi = false;
    private boolean hasActiveBookingForVan = false;

    private static Scanner scanner = new Scanner(System.in);
    private QueueManager queueManager;
    
    public Customer(String uniqueUsername, String encryptedPassword) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = QueueManager.getInstance(); 
        this.taxiType = "";
        this.activeBooking = false;
    }
    
    public boolean hasActiveBookingForRegularTaxi() {
        return hasActiveBookingForRegularTaxi;
    }

    public void setHasActiveBookingForRegularTaxi(boolean hasActiveBookingForRegularTaxi) {
        this.hasActiveBookingForRegularTaxi = hasActiveBookingForRegularTaxi;
    }

    public boolean hasActiveBookingForBigTaxi() {
        return hasActiveBookingForBigTaxi;
    }

    public void setHasActiveBookingForBigTaxi(boolean hasActiveBookingForBigTaxi) {
        this.hasActiveBookingForBigTaxi = hasActiveBookingForBigTaxi;
    }

    public boolean hasActiveBookingForVan() {
        return hasActiveBookingForVan;
    }

    public void setHasActiveBookingForVan(boolean hasActiveBookingForVan) {
        this.hasActiveBookingForVan = hasActiveBookingForVan;
    }

    public void displayVanSchedule() {
        queueManager.displayVanSchedule();
    }

    @Override
    public void signUp() {
        System.out.println("Customer registered successfully.");
    }

    public void viewAvailability() {
        QueueManager.getInstance().displayAvailableTaxis();
    }

    public void bookTaxi() throws QueueManagerExceptions {

        System.out.println("\n======== Meetup Stands ========");
        System.out.println("1.  -7/11 stand-");
        System.out.println("2.  -MSME stand-");
        System.out.println("3.  -IT-Building stand-");
        System.out.println("Choose a meetup stand:");
        int stand_choice = scanner.nextInt();
        scanner.nextLine(); 
        String stand = "";
        switch (stand_choice){
            case 1:
                stand = "7/11 stand";
                break;
            case 2:
                stand = "MSME stand";
                break;
            case 3:
                stand = "IT-Building stand";
                break;
            default:
                System.out.println("Available inputs are 1, 2 and, 3!");
                stand_choice = scanner.nextInt();
        }

        System.out.println("Enter Destination:");
        String destination = scanner.nextLine();

        System.out.println("\n========= Taxi Type ========");
        System.out.println("Select (regular/big/van):");
        taxiType = scanner.nextLine().toLowerCase().trim();

        switch (taxiType) {
        	case "regular":
        		bookedTaxi = queueManager.bookRegularTaxi();
        		if (bookedTaxi != null) {
        			bookingId = rand.nextInt(9000) + 1000;
                    System.out.println("Regular taxi booked successfully with Booking ID: " + bookingId);
                    activeBooking = true;
                    System.out.println("Currently waiting for booking time............");
                    System.out.println("\n   -Booking info-");
                    System.out.println("Booked Vehicle type: Regular Taxi");
                    System.out.println("Meetup Stand: "+stand);
                    System.out.println("Destination: "+destination);
                } else {
                    System.out.println("No regular taxis available at the moment.");
                }
                break;
        	case "big":
        		bookedTaxi = queueManager.bookBigTaxi();
        		if (bookedTaxi != null) {
        			bookingId = rand.nextInt(9000) + 1000;
                    System.out.println("Big taxi booked successfully with Booking ID: " + bookingId);
                    activeBooking = true;
                    System.out.println("Currently waiting for booking time............");
                    System.out.println("\n   -Booking info-");
                    System.out.println("Booked Vehicle type: Big Taxi");
                    System.out.println("Meetup Stand: "+stand);
                    System.out.println("Destination: "+destination);
                } else {
                    System.out.println("No big taxis available at the moment.");
                }
                break;
            case "van":
                queueManager.displayVanSchedule();
                System.out.println("Enter preferred time slot for Van (e.g., 09:00 AM):");
                String timeSlot = scanner.nextLine().trim();
                queueManager.bookVanSlot(timeSlot);
                bookingId = rand.nextInt(9000) + 1000;
                System.out.println("Van slot pre-booked successfully with Booking ID: " + bookingId);
                activeBooking = true;
                System.out.println("Currently waiting for booking time............");
                System.out.println("\n   -Booking info-");
                System.out.println("Booked Vehicle type: Van");
                System.out.println("Booked Time: "+timeSlot);
                System.out.println("Meetup Stand: "+stand);
                System.out.println("Destination: "+destination);

                break;
            default:
                System.out.println("Invalid taxi type selected.");
                break;
        }

    }
 
    public void cancelBooking() {
        if (!hasActiveBooking()) {
            System.out.println("You don't have any active bookings.");
            return;
        }
        activeBooking = false;

		System.out.println("Booking ID ["+bookingId+"] canceled successfully.");
		if (bookedTaxi instanceof RegularTaxi) {
		    queueManager.returnRegularTaxi((RegularTaxi) bookedTaxi);
		} else if (bookedTaxi instanceof BigTaxi) {
		    queueManager.returnBigTaxi((BigTaxi) bookedTaxi);
		} else {
		    System.out.println("Invalid taxi type selected.");
		}
      }
    

    public boolean hasActiveBooking() {
        return activeBooking;
    }

    public void prebookVan(String time) {
        System.out.println("Van pre-booked successfully!");
    }
    
}