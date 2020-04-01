package go.com.test;

public class StaticClass {


    public static void main(String[] args) {
        testa();
    }

    public static void testa() {
        T t = new T();
        t.goone();
    }
}


class T {
    public void goone() {
        System.out.println(111);

    }
}

