package QStandProject;

public abstract class User {
    private static int idCounter = 1; 
    private int id;
    protected String uniqueUsername;
    protected String encryptedPassword;
    
    public User(String uniqueUsername, String encryptedPassword) {
        if(uniqueUsername.length() <= 1 || encryptedPassword.length() <= 1) {
            throw new IllegalArgumentException("Username and password should be more than 1 character long.");
        }
        this.id = idCounter++;
        this.uniqueUsername = uniqueUsername;
        this.encryptedPassword = encryptedPassword;
    }
    
    public void displayAvailableTaxis() {
    	System.out.println("Displaying available taxis");
    }
    
    public void setUsername(String uniqueUsername) {
        if(uniqueUsername.length() <= 1) {
            System.out.println("Error: Username should be more than 1 character.");
            return;
        }
        this.uniqueUsername = uniqueUsername;
    }

    public void setPassword(String encryptedPassword) {
        if(encryptedPassword.length() <= 1) {
            System.out.println("Error: Password should be more than 1 character.");
            return;
        }
        this.encryptedPassword = encryptedPassword;
    }
    
    public boolean login(String username, String password) {
        return this.uniqueUsername.equals(username) && this.encryptedPassword.equals(password);
    }
    
    public void logOut() {
        System.out.println("Logged out successfully.");
    }
        
    public String getUsername() {
        return uniqueUsername;
    }
    
    public String getPassword() {
        return encryptedPassword ;
    }

	public void signUp() {
        System.out.println("User account created successfully!");
    }
	
    public String toString() {
        return "User ID: " + id + ", Username: " + uniqueUsername;
    }
}