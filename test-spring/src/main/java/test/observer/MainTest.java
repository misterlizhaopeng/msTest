package test.observer;

public class MainTest {


    public static void main(String[] args) {

        Products instance = Products.getInstance();

        JDObserver jdObserver=new JDObserver();
        TBObserver tbObserver=new TBObserver();
        instance.addProductObserver(jdObserver);
        instance.addProductObserver(tbObserver);
        instance.addProduct("小麦");

    }
}