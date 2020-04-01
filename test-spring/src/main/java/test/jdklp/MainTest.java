package test.jdklp;

public class MainTest {
    public static void main(String[] args) {
        CalcInterface calcInterface =new CalcInterfaceImpl();

        CalcInterface  instance= (CalcInterface) LoggingHandler.createProxyInstance(calcInterface);
        int addResult = instance.add(1, 2);
       // System.out.println(addResult);


    }
}
