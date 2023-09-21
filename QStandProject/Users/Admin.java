package QStandProject;

public class Admin extends User {
    
    private QueueManager queueManager;

    public Admin(String uniqueUsername, String encryptedPassword) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = QueueManager.getInstance(); 
    }
    
    public void viewAvailability() {
        queueManager.displayAvailableTaxis();
    }

    public void displayVanSchedule() {
        queueManager.displayVanSchedule();
    }
    
    @Override
    public boolean login(String username, String password) {
        return super.login(username, password);
    }

    public void addTaxi(String taxiType, String taxiId) {
        switch (taxiType.toLowerCase()) {
            case "regular":
                queueManager.addRegularTaxi(new RegularTaxi(taxiId));
                break;
            case "big":
                queueManager.addBigTaxi(new BigTaxi(taxiId));
                break;
            case "van":
                queueManager.addVan(new Van(taxiId));
                break;
            default:
                System.out.println("Invalid Taxi Type");
        }
    }

    public void removeTaxi(String taxiId) {      
        System.out.println("Removed taxi with ID: " + taxiId + " from the system.");
    }
}