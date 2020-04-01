package go.com.test;

public class AbstractB extends AbstractClsTest {


    @Override
    String goStr() {
        return null;
    }

    @Override
    public void exeMethod() {
        super.exeMethod();
        System.out.println("--->AbstractB");
    }
}
