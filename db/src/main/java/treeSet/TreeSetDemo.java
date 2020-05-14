package treeSet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。它继承了AbstractSet抽象类，实现了Cloneable接口，TreeSet
 * 是基于TreeMap 实现的，TreeSet 的元素支持2 中排序方式，自然排序或者根据提供的Comparator 进行排序。
 * TreeSet是一个包含有序的且没有重复元素的集合，通过TreeMap 实现。 TreeSet 中含有一个NavigableMap 类型的成员
 * 变量，而m 实际上是TreeMap 的实例
 *
 * 自然排序：TreeMap 的所有可以 必须实现Comparable 接口，所有的key 都是同一个类的对象。
 * 定制排序：创建TreeMap对象传入一个Comparator 对象，该对象负责对TreeMap 中所有的key 进行排序，，
 * 采用定制排序不要求Map的key 实现Comparator 接口，
 * 比较方法，如果comparator==null ,采用comparable.compartTo进行比较，否则采用指定比较器比较大小
 * 对于Map 来说，使用的最多就是put()/get()/remove() 等方法。
 */
public class TreeSetDemo {


    /*public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<Person>();
        for (int i = 0; i < 4; i++) {
            ts.add(new Person(i+"name",i));
        }
        java.lang.ClassCastException: treeSet.Person cannot be cast to java.lang.Comparable
        显然是出现了类型转换异常。原因在于我们需要告诉TreeSet如何来进行比较元素，如果不指定，就会抛出这个异常
    }*/
    /**
     * 如何解决上面的异常呢？
     * 如何指定比较的规则，需要在自定义类（Person） 中实现Comparable 接口，并重写接口中的compareTo 方法。
     *如果将compareTo()返回值写死为0，元素值每次比较，都认为是相同的元素，这时就不再向TreeSet中插入除第一个外的新元素。所以TreeSet中就只存在插入的第一个元素。
     * 如果将compareTo()返回值写死为1，元素值每次比较，都认为新插入的元素比上一个元素大，于是二叉树存储时，会存在根的右侧，读取时就是正序排列的。
     * 如果将compareTo()返回值写死为-1，元素值每次比较，都认为新插入的元素比上一个元素小，于是二叉树存储时，会存在根的左侧，读取时就是倒序序排列的。

     */
    public static void main(String[] args) {
       /* TreeSet<Person> ts = new TreeSet<Person>(new CompareAge());
        for (int i = 6; i > 0 ; i--) {
            ts.add(new Person(i+"name",i));
        }
        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.higher(new Person("4name",4)));
        ts.*/
        TreeMap<String,String> ts = new TreeMap<String, String>();
        ts.keySet()
    }
}

// 红黑树是一个更高效的检索二叉树，有如下特点：
/**
 * 1、每个节点只能是红色或者黑色。
 * 2、根节点永远是黑色。
 * 3、所有的叶子的子节点都是空节点，并且都是黑色。
 * 4、每个红色节点的两个子节点都是黑色（不会有两个连续的红色节点）
 *
 *
 **/
// 红黑树的插入与删除：
/**
 * 删除红黑树的操作比插入操作要稍微麻烦一点：
 * 分为两步：
 * 以排序二叉树的方法删除指定节点。删除的节点存在三种情况：
 * 被删除节点，没有左右孩子节点，直接删除即可。
 * 被删除节点，有一个孩子节点，那么让它的孩子节点指向它的父亲节点即可。
 * 被删除的节点，有两个非空的孩子节点，那么需要找到该节点的前驱或者后继及诶点，
 **/