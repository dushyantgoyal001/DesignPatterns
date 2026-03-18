package ObserverDesignPattern;

import java.util.List;

public class YoutubeChannel implements Subject {
    List<Observer> observers;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.notified(message);
        }
    }

}
