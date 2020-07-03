package runDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk ��̬����������ʼ");
        Object result = method.invoke(target,args);
        System.out.println("JDK��̬��������������");
        return result;
    }
    // �����ȡ������󷽷�
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
