package duoxiancheng;

public class Test {
    public static void main(String[] args) {
        Air air = new Air();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                air.dec();
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
             new Thread(()->{
                 air.inc(); },String.valueOf(i)).start();
        }

    }
}
