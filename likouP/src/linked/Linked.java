package linked;

public class Linked <T> {
    /**
     * ʵ��һ���ڲ���
     */
    class Node{
        private T t;
        private Node next;
        public Node(T t,Node next){
            this.t =  t;
            this.next = next;
        }
        public Node(T t){
            this(t,null);
        }
    }
    private Node head ;
    private Integer size;
    public Linked(){
        this.head = null;
        this.size = 0;
    }

    /**
     * ������β��������
     * @param t
     */
    public void add(T t){
        Node node = new Node(t);
        if(this.head == null){
            this.head = node;
        }else{
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    /**
     * ������ͷ��������
     * @param t
     */
    public void headAdd(T t) {
        /*�µĽڵ�*/
        Node node = new Node(t);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /**
     * ɾ�����һ��Ԫ��
     * @return
     */
    public T deleteLast(){
        if(this.head == null){
            System.out.println("��Ԫ�ؿ�ɾ��");
            return null;
        }
        if(this.size == 1){
            T t = this.head.t;
            this.head = null;
            return t;
        }
        Node cur = this.head;
        Node prev = this.head;
        while (cur.next != null){
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        this.size --;
        return  cur.t;
    }
    /**
     *��ת���� ������д��
     */
     public  void reverse(Node head){
         if(head == null || head.next == null) return;
         Node cur = head;
         Node prev = null;
         while (cur.next != null){
             Node temp = cur.next;
             cur.next = prev;
             prev = cur;
             cur = temp;
         }
         cur.next = prev;
         this.head = cur;
     }
     /******************************************************�ݹ�**********************************************/
    /**
     * ��ת���� ,�ݹ�ķ���
     */
    public  Node reverse01(Node head){
       if(head.next == null || head == null) return head;
       Node last = reverse01(head.next);
       head.next.next = head;
       head.next = null;
       return  last;
    }

    /**
     * ��ת����ǰk���ڵ�
     *  // ��ת�� head Ϊ���� n ���ڵ㣬�����µ�ͷ���
     *  1��base case ��Ϊ n == 1����תһ��Ԫ�أ�����������ͬʱҪ��¼�����ڵ㡣
     */
     Node next = null;
     public Node reverseN(Node head,int k){
        if(k == 1){
            // ��¼�� n + 1 ���ڵ�
            next = head.next;
            return head;
        }
         // �� head.next Ϊ��㣬��Ҫ��תǰ n - 1 ���ڵ�
        Node last = reverseN(head.next , k -1 );
        head.next.next = head;
         // �÷�ת֮��� head �ڵ�ͺ���Ľڵ�������
        head.next = next;
        return last;
     }
    /**
     * ��תm - n ��Ԫ��
     *
     */
    Node reverseBetween(Node head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // ǰ������ת����㴥�� base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    /**
     * �������������еĽڵ�
     *  1->2->3->4
     *  2->1->4->3
     */
    public void swapPairs(Node head) {

    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = this.head;
        while(cur != null){
            sb.append(cur.t+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        Linked<Integer> linked = new Linked<>();
        linked.add(5);
        linked.add(6);
        linked.add(7);
        linked.add(8);
        System.out.println(linked.toString());
        //linked.reverse(linked.head);
        linked.head = linked.reverse01(linked.head);
        System.out.println(linked.toString());


    }

}
