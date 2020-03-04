package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FanSheTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        FanShe fanShe = new FanShe();
       // Class fashecl = fanShe.getClass();
        //Class fans = FanShe.class;
        Class fa = Class.forName("com.test.FanShe");
        //通过Class对象获取类名
        String className = fa.getName();
        int modifiers = fa.getModifiers();
        System.out.println(modifiers);
        /*getFields获得所有 public 修饰的成员变量，包括父类。
        getDeclaredFields获得所有成员变量，但不包括父类。*/
        for (Field field : fa.getFields()) {
            System.out.println(field.getName());
        }
        for (Method method : fa.getMethods()) {
            System.out.println(method.getName());
            if(method.getName().equals("add")){
                int i = (int) method.invoke(5,6);
                System.out.println(i);
            }

        }

    }
}
