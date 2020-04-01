package test.jdklp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityHandler implements InvocationHandler {

    private  Object target;
    public SecurityHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
