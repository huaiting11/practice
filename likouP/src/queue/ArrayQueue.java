package queue;

/**
 * ���� ʵ�ֶ���
 * /**
 *  * �����Ͷ���
 *  * <p>
 *  * ͬ����Ҫһ��ͷָ�룬һ��βָ��  ��ͷָ��=βָ��=0ʱ��Ϊ��
 *  * ��Ҫʵ�ַ���һ���̶���С������
 *  * ����������£�βָ����Զָ���βԪ�ص���һ��λ�ã�����˵��βԪ����0 βָ������1
 *  * <p>
 *  * ע�⣡�������Ͷ����кܴ�����ƣ�������ɴ洢�ռ��˷ѣ����Ҳ������ݡ�
 *  * ����˵�����ռ�Ϊ6��������У� ��ȥ��6����Ԫ�أ�Ȼ��Ӷ�ͷ��ȥ��5��Ԫ�أ���ʱ����Ȼ���ܲ����µ�Ԫ��
 *  * ��Ϊ��βָ����Ȼָ���6��Ԫ�أ�����Ȼռ�������һ��λ�ã�����ͷ�ǲ��������ġ��������ǰ��5��λ���˷ѡ�
 *  * <p>
 *  * ���������1.Ԫ���ƶ�λ�ã�����һ�� �����Ԫ����ǰŲ��   ȱ�㣺ÿ�γ��Ӷ���Ҫ�ƶ�λ�� ���鷳 Ч��Ҳ��
 *  * 2.��̬���ݣ�  ȱ�㣺�˷���ǰ��Ŀռ�
 *  * 3.��ѽ�����������컷�ζ���
 *  */
public class ArrayQueue<T> implements IQueue {
    private Integer size;
    private Integer header;
    private Integer tail;
    private final Integer length = 6;
    private Object[] arr;

    public IQueue InitQueue() {
        arr = new Object[length];
        tail = header = size = 0;
        return this;
    }

    public IQueue DestroyQueue() {
        arr = null;
        tail = header = size = 0;
        return this;
    }

    public IQueue ClearQueue() {
        tail = header = size = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        return this;
    }

    public Boolean isEmpty() {
        if (tail == header) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Integer QueueLength() {
        return size;
    }

    public Object GetHead() {
        return arr[header];
    }

    public Boolean EnQueue(Object e) {
        if (size >= length) {
            return Boolean.FALSE;
        }
        if (header == tail) {//���ж��ǲ��ǿյ� ����� ����ͷβָ��  ,��Ȼ������о�ֻ����һ����
            header = 0;
            arr[header] = e;
            tail = 1;
        } else {
            arr[tail] = e;
            tail = tail + 1;
        }
        size++;
        return Boolean.TRUE;


    }

    public Object DeQueue() {
        if (header == tail) {
            return null;
        }
        T e = (T) arr[header];
        header = header + 1;
        size--;
        return e;
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        arrayQueue.InitQueue();
        arrayQueue.EnQueue(1);
        arrayQueue.EnQueue(2);
        arrayQueue.EnQueue(3);
        arrayQueue.EnQueue(4);
        arrayQueue.EnQueue(5);
        arrayQueue.EnQueue(6);
        Integer s = arrayQueue.size;
        System.out.println(arrayQueue.GetHead());
        for (Integer integer = 0; integer < s; integer++) {
            System.out.println(arrayQueue.DeQueue());
        }
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.EnQueue(1);
        arrayQueue.EnQueue(2);
        arrayQueue.EnQueue(3);
        arrayQueue.EnQueue(4);
        s = arrayQueue.size;
        for (Integer integer = 0; integer < s; integer++) {
            System.out.println(arrayQueue.DeQueue());
        }
        System.out.println(arrayQueue.isEmpty());
    }
}
