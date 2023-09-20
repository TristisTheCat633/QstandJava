package QStandProject;

public class Admin extends User {
    
    private QueueManager queueManager;

    public Admin(String uniqueUsername, String encryptedPassword, QueueManager queueManager) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = queueManager;  
    }
    
    public void viewAvailability() {
        int regularTaxiCount = queueManager.getAvailableRegularTaxis();
        int bigTaxiCount = queueManager.getAvailableBigTaxis();
        int vanCount = queueManager.getAvailableVans();


        System.out.println("Available Taxis");
        System.out.println("Regular Taxi : " + regularTaxiCount);
        System.out.println("Big Taxi : " + bigTaxiCount);
        System.out.println("Van : " + vanCount);
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
                queueManager.addRegularTaxi();
                break;
            case "big":
                queueManager.addBigTaxi();
                break;
            case "van":
                queueManager.addVan();
                break;
        }
        System.out.println("Added a new " + taxiType + " taxi to the system.");
    }

    public void removeTaxi(String taxiId) {      
        System.out.println("Removed taxi with ID: " + taxiId + " from the system.");
    }
}