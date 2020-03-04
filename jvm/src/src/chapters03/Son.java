package chapters03;

/**
 * 解析调用中非虚方法。虚方法的测试
 *
 *
 * 它首先去看父类里面有没有静态代码块，如果有，
 * 它先去执行父类里面静态代码块里面的内容，
 * 当父类的静态代码块里面的内容执行完毕之后，接
 * 着去执行子类(自己这个类)里面的静态代码块，
 * 当子类的静态代码块执行完毕之后，它接着又去看父类有没有非静态代码块，
 * 如果有就执行父类的非静态代码块，父类的非静态代码块执行完毕，
 * 接着执行父类的构造方法；父类的构造方法执行完毕之后，它
 * 接着去看子类有没有非静态代码块，如果有就执行子类的非静态
 * 代码块。子类的非静态代码块执行完毕再去执行子类的构造方法
 * ，这个就是一个对象的初始化顺序。
 */
class Father{
    public Father(){
        System.out.println("father 的构造器");
    }
    public static void showStatic(String str){
        System.out.println("father"+str);
    }
    public final void showFinal(){
        System.out.println("show final");
    }
    public void showCommon(){
        System.out.println("father 普通方法");
    }
}
public class Son extends  Father{
    public Son(){
        System.out.println("Son 的构造器");
    }
    {
        System.out.println("dddd");
    }
    public Son(int age){
        this();
    }
    // 不是重写父类的方法，静态方式不能被重写。
    public static void showStatic(String str){
        System.out.println("Son"+str);
    }
    private void showPrivate(){
        System.out.println("Son  private");
    }
    private void show(){
        showStatic("hello");
        super.showStatic("good");
        showPrivate();
        super.showCommon();
        showFinal();
    }

}
