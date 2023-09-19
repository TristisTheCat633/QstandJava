package QStandProject;

public class Admin extends User {
	
    private QueueManager queueManager; 
    public Admin(String uniqueUsername, String encryptedPassword) {
        super(uniqueUsername, encryptedPassword);
        this.queueManager = new QueueManager();
    }
    
    public void viewAvailability() {
        System.out.println("Displaying available taxis...");
    }

    public void displayVanSchedule() {
        queueManager.displayVanSchedule();
    	}
    
    @Override
    public boolean login(String username, String password) {
        return super.login(username, password);
    }
    

    public void addTaxi( String taxiType, String taxiId) {
        System.out.println("Added a new " + taxiType + " taxi to the system.");
    }
    public void removeTaxi(String taxiId) {      
        System.out.println("Removed taxi with ID: " + taxiId + " from the system.");
    }
}
