package treeSet;

public class Entry<K,V> {
    K key; // ¼ü
    V value;
    Entry<K,V> left = null;
    Entry<K,V> right = null;
    Entry<K,V> parent;
    boolean color = true;
    Entry(K key,V  value,Entry<K,V> parent){
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
    // ·µ»Økey
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }

    public V put(K key,V value){
        return null;
    }

}
