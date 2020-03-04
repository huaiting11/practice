package test;

public class Test {
    public static void main(String[] args) {
        Air air = new Air();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                air.dec();
            },String.valueOf(i)+"线程").start();
        }
        for (int i = 0; i < 10; i++) {
             new Thread(()->{
                 air.inc(); },String.valueOf(i)+"线程").start();
        }

    }
}
