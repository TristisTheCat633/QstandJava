package QStandProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws QueueManagerExceptions {
       
        Console_U interF_U = new Console_U();
        Console_AD interF_AD = new Console_AD();
        
        System.out.println("Welcome to Q-Stand");
        System.out.println("\nAre you a customer or an admin?");
        System.out.println("1.Customer");
        System.out.println("2.Admin");

        Scanner Input = new Scanner(System.in);
        int choice = Input.nextInt();
        Input.nextLine(); 
        switch (choice) {
            case 1:
                interF_U.display();
                break;
            case 2:
                interF_AD.display();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        Input.close();
    }
    
}
