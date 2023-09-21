package QStandProject;

public class Main {
    public static void main(String[] args) throws QueueManagerExceptions {


    	Admin Tris = new Admin("admin1", "password1");
    	Customer Potato = new Customer("Potato", "password1");
    	Customer Watermelon = new Customer("Watermelon", "password2");
    	Customer Papaya = new Customer("Papaya", "password3");



        Tris.addTaxi("Regular", "4E1412");
        Tris.addTaxi("Big", "5F5612");
        Tris.addTaxi("Van", "6G9112");
        Tris.addTaxi("Regular", "1D2412");
        Tris.addTaxi("Big", "3E1312");
        Tris.addTaxi("Van", "9K4312");

        Potato.login("Potato", "password1");
        Potato.viewAvailability();
        Potato.bookTaxi();

        Watermelon.login("Watermelon", "password2");
        Watermelon.viewAvailability();
        Watermelon.bookTaxi();

        Papaya.login("Papaya", "password3");
        Papaya.viewAvailability();
        Papaya.displayVanSchedule();
        Papaya.prebookVan(Papaya, "10:00AM");
    }
}