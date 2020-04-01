package test.observer;

import java.util.Observable;
import java.util.Observer;

public class JDObserver implements Observer {
    @Override
    public void update(Observable o, Object product) {

        String p=(String)product;
        System.out.println("京东收到产品："+p);
    }
}
