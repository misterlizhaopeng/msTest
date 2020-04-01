package test.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者（产品）
 */
public class Products extends Observable {

    //类的唯一实例
    private static Products instance =null;
    private List<String> productList;

    //私有构造方法
    private Products(){}

    public static Products getInstance(){
        if (instance==null){
            instance= new Products();
            instance.productList=new ArrayList<>();
        }
        return instance;
    }


    /**
     * 增加观察者
     * @param observer
     */
    public  void addProductObserver(Observer observer){
        this.addObserver(observer);
    }


    /**
     * 增加产品
     */
    public void addProduct(String product){
        productList.add(product);
        System.out.println("产品列表新增了产品："+product);
        this.setChanged();//设置被观察者发生了变化
        this.notifyObservers(product);//通知观察者
    }

}