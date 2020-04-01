package test.jdklp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private  Object target;

    /**
     * 创建代理对象的实例,在创建代理对象的时候用到
     * @param target
     */
    public LoggingHandler(Object target){
        this.target = target;
    }

    /**
     * 通过反射技术，调用被代理对象的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before  invoked");
        Object invoke = method.invoke(this.target, args);
        System.out.println("----------->"+invoke);
        System.out.println("after  invoked");
        return  invoke;
    }

    /**
     * 创建代理的对象
     * @param tar
     * @return
     */
    public static Object createProxyInstance(Object tar){
        Object o = Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), new LoggingHandler(tar));
        return o;
    }
}
