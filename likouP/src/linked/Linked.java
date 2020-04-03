package linked;

public class Linked <T> {
    /**
     * 实现一个内部类
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
     * 向链表尾部加数据
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
     * 向链表头部加数据
     * @param t
     */
    public void headAdd(T t) {
        /*新的节点*/
        Node node = new Node(t);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T deleteLast(){
        if(this.head == null){
            System.out.println("无元素可删除");
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
     *翻转链表 迭代的写法
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
     /******************************************************递归**********************************************/
    /**
     * 翻转链表 ,递归的方法
     */
    public  Node reverse01(Node head){
       if(head.next == null || head == null) return head;
       Node last = reverse01(head.next);
       head.next.next = head;
       head.next = null;
       return  last;
    }

    /**
     * 翻转链表，前k个节点
     *  // 反转以 head 为起点的 n 个节点，返回新的头结点
     *  1、base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱节点。
     */
     Node next = null;
     public Node reverseN(Node head,int k){
        if(k == 1){
            // 记录第 n + 1 个节点
            next = head.next;
            return head;
        }
         // 以 head.next 为起点，需要反转前 n - 1 个节点
        Node last = reverseN(head.next , k -1 );
        head.next.next = head;
         // 让反转之后的 head 节点和后面的节点连起来
        head.next = next;
        return last;
     }
    /**
     * 翻转m - n 个元素
     *
     */
    Node reverseBetween(Node head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    /**
     * 两两交换链表中的节点
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
