package DatabaseConnection;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
        System.out.println("Database Connection Created");
    }

    private static DatabaseConnection getInstance() {
        if(instance == null) {
           synchronized (DatabaseConnection.class) {
                if(instance == null) {
                     instance = new DatabaseConnection();
                }
           }
        }
        return instance;
    }
    private void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.executeQuery("SELECT * FROM users");

        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        connection2.executeQuery("SELECT * FROM orders");

        System.out.println("Are both connections the same instance? " + (connection1 == connection2));
    }
}
