package test.inteceptor;

public class MainTest {
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) DynamicCls.bind(new HelloWorldImpl(), "test.inteceptor.MyInterceptor");
        helloWorld.sayHello();
    }
}
