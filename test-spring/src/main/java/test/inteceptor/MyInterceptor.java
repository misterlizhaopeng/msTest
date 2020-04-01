package test.inteceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements  Interceptor{
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("before");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("around");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("after");
    }
}
