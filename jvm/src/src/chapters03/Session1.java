package chapters03;

import java.util.Date;

public class Session1 {
    private int count = 1;
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        Date date = new Date();
        String name1 = "atguigu.com";
        // 因为this 变量 不存在于当前方法的局部变量中；
        //System.out.println(this.count);
        System.out.println("hello world");
    }
    // 关于 slot 使用的理解
    public  Session1(){
        this.count = 0;
    }
    public void test(){
        Date date = new Date();
        String name1 = "atguigu.com";
        // 因为this 变量 不存在于当前方法的局部变量中；
        System.out.println(this.count);
        System.out.println("hello world");
    }
    // 栈帧中的局部变量表中的槽位 是可以重用的，如果一个局部变量过了其作用域，那么在
    // 其作用域之后申明的新的局部变量就很有可能会重复过期局部变量的槽位，从而达到节省资源的目的

    public void localVarl(){
        int a = 0;
        System.out.println(a);
        int b = 0;
    }
    public void localVarl2(){
        {
            int a = 0;
            System.out.println(a);
        }
        // 变量b 使用之前已经销毁的变量a 占据的slot 的位置。
        int b = 0;
    }
    public void test11(){
        int i ;
        // 这样的代码是错误的，没有赋值 不能够使用。
       // System.out.println(i);
    }
}
