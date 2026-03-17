package NotificationSystem;

public class Main {
    public static void main(String[] args) {
       Notification emailNotifcation = new NotificationFactory().createNotifcation("EMAIL");
         emailNotifcation.notifyUser("This is an email notification!");
    }
}
