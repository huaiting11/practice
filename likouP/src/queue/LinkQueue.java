package queue;

public class LinkQueue<T>
{
    class Node<T>
    {
        private T data;//������
        private Node<T> next;//������
        public Node()
        {
            this.data=null;
            this.next=null;
        }
        public Node(T data)
        {
            this.data=data;
            this.next=null;
        }
        public void setNext(Node<T> t)
        {
            this.next=t;
        }
        public T getData()
        {
            return this.data;
        }
        public Node<T> getNext()
        {
            return this.next;
        }
    }
    private Node<T> head;//��ͷ
    private Node<T> tail;//��β
    public LinkQueue()
    {
        this.head=null;
        this.tail=null;
    }
    //���
    public boolean inQueue(T t)
    {
        Node<T> p=new Node<T>(t);//����һ�����
        if(head==null)//���ͷ���ڿ�
        {
            head=p;//ͷ����ָ��������
            tail=p;//β����ָ��������
        }
        else
        {
            tail.next=p;//����β��
            tail=p;//β����ָ���µ�β���
        }
        return true;
    }
    //dream it possible
    //����
    public T outQueue()
    {
        if(head==null) return null;
        else
        {
            T t=head.getData();//ȡ�¶Զ�ͷ
            head=head.next;//ͷ���ú���
            return t;
        }

    }
    //���ͷ
    public T peek()
    {
        if(head==null) return null;
        else
            return head.getData();
    }
    //�п�
    public boolean isEmpty()
    {
        return head==null;
    }
}
