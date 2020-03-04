package chapters03;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
    }
    {
        System.out.println("非静态代码块");
    }
    {
        System.out.println("非静态代码块1");
    }
    Test(){
        System.out.println("Test");
    }
    {
        System.out.println("非静态代码块3");
    }
    {
        System.out.println("非静态代码块4");
    }



}
