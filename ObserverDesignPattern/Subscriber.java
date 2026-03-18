package ObserverDesignPattern;

public class Subscriber  implements Observer {
    private String name;
    public Subscriber(String alice) {
        this.name = alice;
    }

    @Override
    public void notified(String message) {
        System.out.println( this.name +" "+ "received notification: " + message);
    }
}
