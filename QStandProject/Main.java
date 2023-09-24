package QStandProject;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws QueueManagerExceptions {
        startConsole();
    }

    public static void startConsole() throws QueueManagerExceptions {
        Console_U interF_U = null;
        Console_AD interF_AD = null;

        System.out.println("\nWelcome to Q-Stand\n");
        System.out.println("Are you a customer or an admin?");
        System.out.println("1.Customer");
        System.out.println("2.Admin");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if (choice == 1) {
            interF_U = new Console_U();
            interF_U.display();
        } else if (choice == 2) {
            interF_AD = new Console_AD();
            interF_AD.display();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
        interF_U = null;
        interF_AD = null;
        s.close();
    }
}
