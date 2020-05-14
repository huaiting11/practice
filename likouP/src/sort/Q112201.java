package sort;

import java.util.TreeMap;

public class Q112201 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer ,Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length ; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i], 0) + 1);
        }
        int i = 0;
        for (int j = 0; j < arr2.length; j++) {
            while (map.get(arr2[j]) > 0 ) {
                arr1[i++] = arr2[j];
                map.put(arr2[j] ,map.get(arr2[j]) - 1);
            }
        }
        for(int n : map.keySet()){
            while (map.get(n) > 0){
                arr1[i++] = n;
                map.put(n,map.get(n) -1);
            }
        }
        return arr1;
    }
}
