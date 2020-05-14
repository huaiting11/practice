package treeSet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeSet ��һ������ļ��ϣ������������ṩ�����Set���ϡ����̳���AbstractSet�����࣬ʵ����Cloneable�ӿڣ�TreeSet
 * �ǻ���TreeMap ʵ�ֵģ�TreeSet ��Ԫ��֧��2 ������ʽ����Ȼ������߸����ṩ��Comparator ��������
 * TreeSet��һ�������������û���ظ�Ԫ�صļ��ϣ�ͨ��TreeMap ʵ�֡� TreeSet �к���һ��NavigableMap ���͵ĳ�Ա
 * ��������m ʵ������TreeMap ��ʵ��
 *
 * ��Ȼ����TreeMap �����п��� ����ʵ��Comparable �ӿڣ����е�key ����ͬһ����Ķ���
 * �������򣺴���TreeMap������һ��Comparator ���󣬸ö������TreeMap �����е�key �������򣬣�
 * ���ö�������Ҫ��Map��key ʵ��Comparator �ӿڣ�
 * �ȽϷ��������comparator==null ,����comparable.compartTo���бȽϣ��������ָ���Ƚ����Ƚϴ�С
 * ����Map ��˵��ʹ�õ�������put()/get()/remove() �ȷ�����
 */
public class TreeSetDemo {


    /*public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<Person>();
        for (int i = 0; i < 4; i++) {
            ts.add(new Person(i+"name",i));
        }
        java.lang.ClassCastException: treeSet.Person cannot be cast to java.lang.Comparable
        ��Ȼ�ǳ���������ת���쳣��ԭ������������Ҫ����TreeSet��������бȽ�Ԫ�أ������ָ�����ͻ��׳�����쳣
    }*/
    /**
     * ��ν��������쳣�أ�
     * ���ָ���ȽϵĹ�����Ҫ���Զ����ࣨPerson�� ��ʵ��Comparable �ӿڣ�����д�ӿ��е�compareTo ������
     *�����compareTo()����ֵд��Ϊ0��Ԫ��ֵÿ�αȽϣ�����Ϊ����ͬ��Ԫ�أ���ʱ�Ͳ�����TreeSet�в������һ�������Ԫ�ء�����TreeSet�о�ֻ���ڲ���ĵ�һ��Ԫ�ء�
     * �����compareTo()����ֵд��Ϊ1��Ԫ��ֵÿ�αȽϣ�����Ϊ�²����Ԫ�ر���һ��Ԫ�ش����Ƕ������洢ʱ������ڸ����Ҳ࣬��ȡʱ�����������еġ�
     * �����compareTo()����ֵд��Ϊ-1��Ԫ��ֵÿ�αȽϣ�����Ϊ�²����Ԫ�ر���һ��Ԫ��С�����Ƕ������洢ʱ������ڸ�����࣬��ȡʱ���ǵ��������еġ�

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

// �������һ������Ч�ļ������������������ص㣺
/**
 * 1��ÿ���ڵ�ֻ���Ǻ�ɫ���ߺ�ɫ��
 * 2�����ڵ���Զ�Ǻ�ɫ��
 * 3�����е�Ҷ�ӵ��ӽڵ㶼�ǿսڵ㣬���Ҷ��Ǻ�ɫ��
 * 4��ÿ����ɫ�ڵ�������ӽڵ㶼�Ǻ�ɫ�����������������ĺ�ɫ�ڵ㣩
 *
 *
 **/
// ������Ĳ�����ɾ����
/**
 * ɾ��������Ĳ����Ȳ������Ҫ��΢�鷳һ�㣺
 * ��Ϊ������
 * ������������ķ���ɾ��ָ���ڵ㡣ɾ���Ľڵ�������������
 * ��ɾ���ڵ㣬û�����Һ��ӽڵ㣬ֱ��ɾ�����ɡ�
 * ��ɾ���ڵ㣬��һ�����ӽڵ㣬��ô�����ĺ��ӽڵ�ָ�����ĸ��׽ڵ㼴�ɡ�
 * ��ɾ���Ľڵ㣬�������ǿյĺ��ӽڵ㣬��ô��Ҫ�ҵ��ýڵ��ǰ�����ߺ�̼����㣬
 **/