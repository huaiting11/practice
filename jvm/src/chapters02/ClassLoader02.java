package chapters02;

/**
 * ClassLoader类，它是一个抽象类，其后所有的类加载器都继承自ClassLoader（不包括启动类加载器）
 * 方法名称
 * getParent()
 * sun.misc.Launcher 它是一个java 虚拟机的入口应用
 */
public class ClassLoader02 {
    public static void main(String[] args) {
        //1.
        ClassLoader classLoader = chapters02.ClassLoader02.class.getClassLoader();
        //2.
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);
        //3
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader2);
    }
}
