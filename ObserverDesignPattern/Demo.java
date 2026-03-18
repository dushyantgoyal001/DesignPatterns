package ObserverDesignPattern;

public class Demo {
    public static void main(String[] args) {
        Subject newsPublisher = new YoutubeChannel();
        Subscriber subscriber1 = new Subscriber("Alice");
        Subscriber subscriber2 = new Subscriber("Bob");
        newsPublisher.registerObserver(subscriber1);
        newsPublisher.registerObserver(subscriber2);
        newsPublisher.notifyObservers("New video uploaded!");
    }
}
