package chapters02;

/**
 * 一、启动类加载器（引导类加载器，Bootstrap ClassLoader）
 *  这个类加载器使用c/c++ 语言实现的，嵌套在jvm内部
 *  它用来加载java 的核心库，（JAVA_HOME/jre/lib/rt.jar、resources.jar或
 *  sun.boot.class.path 路径下的内容） ，用于提供jvm 自身需要的类
 *  并不继承自java.lang.ClassLoader,没有父加载器。
 *  加载扩展类和应用程序加载器，并指定为他们的父类加载器。
 *  出于安全考虑，Bootstrap 启动类加载器只加载包名为java、javax、sun等开头的类
 *二、扩展类加载器 Extension ClassLoader
 *  Java 语言编写：由sun.misc.Laush实现
 *  继承于ClassLoader类
 *  从java.ext.dirs 系统属性所指定的目录中加载类库，或从jdk的安装目录的jre/lib/ext
 *  子目录（扩展目录）下加载类库。如果用户创建的jar 放在此目录下，也会自动由扩展类加载器加载
 * 三、应用程序类加载器 AppClassLoader
 *  它负责加载环境变量classpath 或系统属性 java.class.path 指定路径下的类库
 *  该类加载是程序中默认的类加载器，一般来说，java 应用的类都是由它来完成的。
 *  通过ClassLoader.getSystemClassLoader() 方法可以获取到该类加载器
 * 四、用户自定义类加载器
 * 在java 的日常开发应用程序开发中，类的加载几乎由上述3中加载器互相配合执行，在必要时，
 * 我们还可以自定义类加载器，来定制类的加载方式。
 * 为什么要自定义类加载器
 * 隔离加载类
 * 修改类加载的方式
 * 扩展加载源
 * 防止源码泄漏
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassloader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassloader);
        // 获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassloader.getParent();
        System.out.println(extClassLoader);
        // 获取其上层，  获取不到引导类加载器
        ClassLoader boot = extClassLoader.getParent();
        System.out.println(boot);
        // 用户自定类 来说，它的类加载器谁：默认使用系统类加载器 进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//Launcher$AppClassLoader@18b4aac2
      // String类 使用引导类加载器进行加载  -》 java 的核心类库 都是 引导类加载器 加载的
        ClassLoader classLoader1  = String.class.getClassLoader();
        System.out.println(classLoader1); //null

    }
}