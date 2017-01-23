package com.example.daniel.eventbus_example.withRxJava;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Daniel on 1/12/17.
 */

public class MyRxBus {

    // First we create a simple singleton
    private static final MyRxBus instance = new MyRxBus();

    // Second we’ll add a PublishSubject wrapped in a SerializedSubject to the class.
    /*
    A Subject is an Object in RxJava that has the properties of both an Observable and an Observer/Subscriber
     */
    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    protected MyRxBus() {
    }

    public static MyRxBus getInstance(){
        return instance;
    }

    /*
       Third start with adding a register method. The resulting Subscription will be returned
       to the caller so they can unsubscribe whenever they deem appropriate.
     */
    // T is type of data it will emit (from the Observer interface)
    public <T>Subscription register (final Class<T> eventClass, Action1<T> onNext){
        return bus
                .filter(event -> eventClass.getClass().equals(eventClass))
                .map(obj -> (T) obj)
                .subscribe(onNext);
    }

    //The following method post the events.
    // This is simply passing the event to the onNext method of the Subject.
    public void post(Object event){
        bus.onNext(event);
    }

    public Observable<Object> getEvents(){
        return bus;
    }

}

/*
References:
    https://blog.metova.com/how-to-use-rxjava-as-an-event-bus/
    https://lorentzos.com/rxjava-as-event-bus-the-right-way-10a36bdd49ba#.5nts9or2o
    https://quangson8128.github.io/2016/06/23/rxbus-android/
    https://github.com/kaushikgopal/RxJava-Android-Samples/blob/master/app/src/main/java/com/morihacky/android/rxjava/rxbus/RxBusDemo_Bottom3Fragment.java
    https://github.com/metova/rxjava-bus-example/blob/master/src/main/java/com/metova/rxjavaexample/Main.java
 */

/*
private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o){
        bus.onNext(o);
    }

    public Observable<Object> toObservable(){
        return bus;
    }

    public boolean hasObservers(){
        return bus.hasObservers();
    }

    //Singleton
    public static MyRxBus getInstance(){
        if(instance == null){
            instance = new MyRxBus();
        }

        return instance;
    }
 */