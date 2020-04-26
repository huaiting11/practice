package sort;

import java.util.TreeMap;

public class Q1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;
    }
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
    public static void main(String[] args) {
        Q1122 q1122 = new Q1122();
        int[] a1= new int[] {2,3,1,3,2,4,6,19,9,2,7};
        int[] a2= new int[] {2,1,4,3,9,6};
        int[] ints = q1122.relativeSortArray1(a1, a2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
