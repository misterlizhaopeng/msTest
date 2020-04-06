package go.com.service;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class UserService {
    public String getUserById(String userId){

        Observable.create(new Observable.OnSubscribe<UserService>(){

            @Override
            public void call(Subscriber<? super UserService> subscriber) {

                subscriber.onNext(null);
            }
        });

        return  null;
    }
}
