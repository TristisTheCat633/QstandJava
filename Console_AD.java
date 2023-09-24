package QStandProject;

import java.util.Scanner;

public class Console_AD {
    Admin Tris = new Admin("admin1", "password1");

    Scanner manage = new Scanner(System.in);
    String u_name;
    public void display() throws QueueManagerExceptions {
        String message = "\n||------ Welcome to Q-Stand ------||";
        System.out.println(message);
        Landing();
        AdminDashboard();
    }
    public void Landing(){
        System.out.println("  -Log In-");
        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.print("user name: ");
            u_name = manage.nextLine();
            System.out.print("password: ");
            String u_pw = manage.nextLine();
            if (u_name.equals("admin1") && u_pw.equals("password1")) {
                System.out.println("Logged in Successfully !");
                Interlude();
                loginSuccessful = true;
                break;
            } else {
                System.out.println("Wrong user name or password");
            }
        }
    }
    public void AdminDashboard() throws QueueManagerExceptions {
        System.out.println("\n-------Admin Dashboard-------");
        DashboardDisplay();
    }
    public void Interlude(){
        System.out.println("\n<------------------------------->");
    }
    public void DashboardDisplay() throws QueueManagerExceptions {
        System.out.println("======== Menu ========");
        System.out.println("1.  -Edit Taxis-");
        System.out.println("2.  -View Van Schedule-");
        System.out.println("3.  -Log out-");
        System.out.println("\nChoose next activity choice:");
        String activity = manage.nextLine();
        Interlude();
        if(activity.equals("1")){
            ViewActiveTaxis();
        }else if (activity.equals("2")){
            ViewVanSchedule();
        }else if (activity.equals("3")) {
            Logout();
        }
    }
    public void ViewActiveTaxis() throws QueueManagerExceptions {
        System.out.println("1.  -Add Taxis-");
        System.out.println("2.  -Remove taxis-");
        System.out.println("3.  -Menu-");
        String activity = manage.nextLine();
        Interlude();
        if(activity.equals("1")){
            System.out.println("======== Adding Taxi ========");
            System.out.print("Taxi Type: ");
            String taxiType = manage.nextLine();
            System.out.print("Taxi ID: ");
            String taxiId = manage.nextLine();
            Tris.addTaxi(taxiType,taxiId);
            System.out.println("A " + taxiType + " taxi " + taxiId + " has been added to the system !");

            Interlude();
            DashboardDisplay();
            
        }else if (activity.equals("2")){
            System.out.println("======== Removing Taxi ========");
            System.out.print("Taxi Type: ");
            String taxiType = manage.nextLine();
            System.out.print("Taxi Id: ");
            String taxiId = manage.nextLine();
            Tris.removeTaxi(taxiType,taxiId);
            DashboardDisplay();
        }
        else if (activity.equals("3")){
            Interlude();
            DashboardDisplay();
        }
    }
    public void ViewVanSchedule() throws QueueManagerExceptions {
        Interlude();
        DashboardDisplay();
        
    }
    public void Logout(){
        System.out.println("You have logged out successfully." +
                "Thanks for using Q-Stand!");
    }


}