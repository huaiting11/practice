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
        // 1 终止条件
        if (n < 2) {
            return x;
        }
        // 2 准备数据
        // 3 子问题
        double sub = divideGenerate(x, n / 2);
        // 4 合并
        // 5 清理
        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }
}
