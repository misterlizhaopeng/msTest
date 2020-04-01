package test.inteceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理对象的类
 */
public class DynamicCls implements InvocationHandler {

    private Object target;
    private String interceptorStr;

    public DynamicCls(Object target, String interceptorStr) {
        this.target = target;
        this.interceptorStr = interceptorStr;
    }

    /**
     * 1.创建代理对象
     *
     * @param target         被代理对象
     * @param interceptorStr 拦截器字符串表示
     * @return
     */
    public static Object bind(Object target, String interceptorStr) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DynamicCls(target, interceptorStr));
    }


    /**
     * 2.方法的业务逻辑
     *
     * @param proxy  代理对象
     * @param method 方法
     * @param args   方法的传入参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result=null;
        if (interceptorStr == null) return method.invoke(target, args);
        Interceptor interceptor = (Interceptor) Class.forName(interceptorStr).newInstance();
        //before=true:反射方法，否则调用around方法
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
