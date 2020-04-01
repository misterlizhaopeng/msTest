package test.observer;

import java.util.Observable;
import java.util.Observer;

public class TBObserver implements Observer {
    @Override
    public void update(Observable o, Object product) {
        String p=(String)product;
        System.out.println("淘宝收到商品:"+p);
    }
}
