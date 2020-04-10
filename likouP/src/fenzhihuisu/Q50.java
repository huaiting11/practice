package fenzhihuisu;

public class Q50 {
    private double divideSolution(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = divideGenerate(x, Math.abs((long) n));
        return n >= 0 ? v : 1 / v;
    }

    private double divideGenerate(double x, long n) {
        // 1 ��ֹ����
        if (n < 2) {
            return x;
        }
        // 2 ׼������
        // 3 ������
        double sub = divideGenerate(x, n / 2);
        // 4 �ϲ�
        // 5 ����
        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }
}
