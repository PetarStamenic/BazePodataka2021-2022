package observer.implementatios;

import observer.Notification;
import observer.Publisher;
import observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class PublisherImplementation implements Publisher {

    private List<Subscriber> subscribers;

    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Notification notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber listener: subscribers){
            listener.update(notification);
        }
    }
}
