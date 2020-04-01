package test.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 个人理解：DynamicProxy只是封装代理对象的类
*/
public class DynamicProxy implements InvocationHandler {
    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 被代理对象和代理对象绑定关系
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target=target;
        //返回代理对象
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return o;
    }

    /**
     * 动态代理对象在执行方法的时候的逻辑
     *
     * @param proxy  代理对象
     * @param method 方法
     * @param args 调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
