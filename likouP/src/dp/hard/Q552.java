package dp.hard;

public class Q552 {
    int count, M = 1000000007;

    /**
     * �����ķ�����⡣���������͵ݹ�
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        count = 0;
        gen("", n);
        return count;
    }

    public void gen(String s, int n) {
        if (n == 0 && check(s)) {
            count += (count + 1) % M;
        } else if (n > 0) {
            gen(s + "L", n - 1);
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
        }
    }

    public boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
    }
    // ʱ�临�Ӷȣ� o��3^n)

    // ʹ�õݹ鹫ʽ��
    public int checkRecord01(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = func(i);
        }
        int sum = func(n);
        for (int i = 0; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return sum % M;
    }

    public int func(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else if (n == 3) {
            return 7;
        } else {
            return (2 * func(n - 1) - func(n - 4)) % M;
        }
    }

    public int checkRecord023(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int) (sum % M);
    }
}
    // ����3 �� ʹ�ö�̬�滮��
    // �㷨�� ����һ�ַ����У�����ÿ�μ���f[i] ����Ҫ�ݹ���ú�����ֱ���ߵ��ַ����ʼ��λ�á��������ʹ�ü�¼�µ�f[j] ȥ����f����
