package runDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 动态代理，监听开始");
        Object result = method.invoke(target,args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }
    // 定义获取代理对象方法
    private Object getJDKProxy(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserManager jdkProxy1 = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        jdkProxy1.addUser("11212","dfdfd");

    }
}
