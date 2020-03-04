package chapters03;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
       /* for (int i = 0; i < 30; i++) {
             new Thread(()->{

                 StringBuilder s1 = Res.method3();
                 s1.append("d");
                 },String.valueOf(i)).start();

        }*/
       StringBuilder s1 = new StringBuilder();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s1.append("c");
            s1.append("d");
                        },"线程1").start();
        Res.method2(s1);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s1.toString());
    }
}
