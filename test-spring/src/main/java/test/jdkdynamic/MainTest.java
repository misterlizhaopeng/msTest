package test.jdkdynamic;

import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws Exception {
/*

        //通过反射调用指定的方法 ：没有返回值，没有形式参数
        Method method = HelloWorldImpl.class.getMethod("sayHello", null);
        Object invokeRes = method.invoke(new HelloWorldImpl(), null);
        System.out.println(invokeRes);

        //通过反射调用指定的方法：有返回值，有一个形式参数
        Method method1 = HelloWorldImpl.class.getMethod("calcNum", int.class);
        Object re = method1.invoke(new HelloWorldImpl(), 5);
        System.out.println(re);

        //通过反射调用指定的方法：有返回值，有两个形式参数
        HelloWorld helloWorld = new HelloWorldImpl();
        Method method2 = helloWorld.getClass().getMethod("getStrTest", String.class, String.class);
        Object res = method2.invoke(helloWorld, "-a+-", "b-");
        System.out.println(res);
*/

        System.out.println("----------------------------------------------- 动态代理测试");
        // 动态代理测试 start
        DynamicProxy dynamicProxy= new DynamicProxy();
        //绑定代理对象和被代理对象（真实对象）
        HelloWorld hw = (HelloWorld) dynamicProxy.bind(new HelloWorldImpl());
        String strTest = hw.getStrTest("cc", "dd");
        System.out.println("method getStrTest return result is:"+strTest);
        //动态代理测试 end


    }
}
