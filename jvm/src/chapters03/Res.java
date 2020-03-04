package chapters03;

import java.util.concurrent.TimeUnit;

public class Res {
    // 线程安全
    public static void method1(){
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
    }
    // 不安线程安全
    public static void method2( StringBuilder s1){
        s1.append("a");
        s1.append("b");
    }
    public static StringBuilder method3(){
        System.out.println(Thread.currentThread().getName()+"进来了");
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s1.append("b");
        System.out.println(Thread.currentThread().getName()+"出去了");
        System.out.println();
        return s1;
    }
    public static String method4(){
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1.toString();
    }
}
