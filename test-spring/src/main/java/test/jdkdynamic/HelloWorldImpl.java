package test.jdkdynamic;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("say hello 123 !xxx");
    }

    @Override
    public int calcNum(int a) {
        return 10 + a;
    }

    @Override
    public String getStrTest(String s1, String s2) {
        return s1 + s2;
    }
}
