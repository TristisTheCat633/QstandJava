package QStandProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console_U {
    
    private List<Customer> customers = new ArrayList<>();

    private Scanner choice = new Scanner(System.in);
    private String u_name;
    private Customer currentUser;
    
    public Console_U() {
        customers.add(new Customer("Potato", "password1"));
        customers.add(new Customer("Watermelon", "password2"));
        customers.add(new Customer("Papaya", "password3"));
        customers.add(new Customer("ShunPuTu", "password4"));
    }
    
    public void display() throws QueueManagerExceptions {
        String message = "\nWelcome to Q-Stand";
        System.out.println(message);
        Landing();
        UserDashboard();
    }
    public void Landing() {
        while (true) {
            System.out.println("Log in or Sign Up");
            String L_or_S = choice.nextLine();
            
            if (L_or_S.equals("Sign Up")) {
                signUp();
                break;
            } else if (L_or_S.equals("Log in")) {
                if (logIn()) {
                    System.out.println("\nLogin Successfully !");
                    break;
                }
            } else {
                System.out.println("\nThe choice is Sign Up or Log in!");
            }
        }
    }

    private void signUp() {
    String phone_number;
    String u_pw;

    while (true) {
        System.out.print("\nPhone number (at least 10 digits starting with 0): ");
        phone_number = choice.nextLine();
        if (phone_number.length() == 10 || phone_number.length() == 11 && phone_number.startsWith("0")) {
            break;
        } else {
            System.out.println("Phone number should have at least 10 digits and start with 0.");
        }
    }

    System.out.print("user name: ");
    u_name = choice.nextLine();

    while (true) {
        System.out.print("password (at least 6 characters): ");
        u_pw = choice.nextLine();
        if (u_pw.length() >= 6) {
            break;
        } else {
            System.out.println("Password should be at least 6 characters long.");
        }
    }
    System.out.println("\nRegistration Successful!");
    
    Customer newUser = new Customer(u_name, u_pw);
    customers.add(newUser);
    currentUser = newUser; 
    }

    private boolean logIn() {
        System.out.print("\nuser name: ");
        u_name = choice.nextLine();
        System.out.print("\npassword: ");
        String u_pw = choice.nextLine();
 

        for (Customer customer : customers) {

            if (customer.getUsername().equals(u_name) && customer.getPassword().equals(u_pw)) { 
                currentUser = customer;
                return true;
            }
        }
        
        System.out.println("Wrong user name or password");
        return false;
    }


    public void UserDashboard() throws QueueManagerExceptions {
        System.out.println("\n-------User Dashboard-------");
        DashboardDisplay();


    }
    public void BookingSuccess(){
        System.out.println("\n   -User Info-");
        System.out.println("User name: "+u_name);
    }
    public void Confirmation_or_Cancellation(){
        System.out.println("Confirm ride");
        System.out.println("User name: "+u_name);
    }
    public void DashboardDisplay() throws QueueManagerExceptions {
        System.out.println("======== Menu ========");
        System.out.println("1.  -View Available Taxis-");
        System.out.println("2.  -View Van Schedule-");
        System.out.println("3.  -Log out-");
        System.out.println("\nChoose next activity choice:");
        String activity = choice.nextLine();
        if(activity.equals("1")){
            ViewAvailableTaxis();
        }else if (activity.equals("2")){
            ViewVanSchedule();
        }else if (activity.equals("3")) {
            Logout();
        }
    }
    public void ViewAvailableTaxis() throws QueueManagerExceptions {
        currentUser.viewAvailability();
        System.out.println("\n1.  -Proceed Booking-");
        System.out.println("2.  -Menu-");
        String activity = choice.nextLine();
        if(activity.equals("1")){
            currentUser.bookTaxi();
            BookingSuccess();
            DashboardDisplay();
        } else if (activity.equals("2")) {
            DashboardDisplay();
        }
    }

    public void ViewVanSchedule() throws QueueManagerExceptions {
        currentUser.displayVanSchedule();
        System.out.println("\n1.  -Proceed Booking-");
        System.out.println("2.  -Menu-");
        String activity = choice.nextLine();
        if(activity.equals("1")){
            currentUser.bookTaxi();
            BookingSuccess();
            DashboardDisplay();
        } else if (activity.equals("2")) {
            DashboardDisplay();
        }
    }

    public void Logout() {
        System.out.println("\nYou have logged out successfully. Thanks for using Q-Stand!");
        currentUser = null;
    }
}