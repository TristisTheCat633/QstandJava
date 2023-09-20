package QStandProject;

public class Main {
    public static void main(String[] args) throws QueueManagerExceptions {

        QueueManager queueManager = new QueueManager();

        Admin Tris = new Admin("admin1", "password1", queueManager);
        Customer Potato = new Customer("Potato", "password1", queueManager);
        Customer Watermelon = new Customer("Watermelon", "password2", queueManager);


        Tris.addTaxi("Regular", "4E1234");
        Tris.addTaxi("Big", "5F5678");
        Tris.addTaxi("Van", "6G9101");
        Tris.addTaxi("Regular", "1D2394");
        Tris.addTaxi("Big", "3E1325");
        Tris.addTaxi("Van", "9K4324");


        Potato.login("Potato", "password1");
        Potato.viewAvailability();


        Potato.bookTaxi();

        Watermelon.login("Watermelon", "password2");
        Watermelon.prebookVan(Watermelon, "11AM");
        Watermelon.viewAvailability();


        Potato.displayVanSchedule();

    }
}
