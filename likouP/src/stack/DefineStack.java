package stack;
public class DefineStack <T>{
    /**
     * 自定义内部类
     * @param <T>
     */
    class Node<T>{
        Node pre;
        T value;
        Node(T t){
            this.value = t;
        }
        @Override
        public String toString() {
            if (this.pre == null) {
                return String.valueOf(this.value);
            }
            return this.pre.toString() + " <- " + this.value;
        }
    }
    public Node<T> root;
    public Node<T> tail;
    public T push(T t){
        if(root == null){
            root = new Node<T>(t);
            tail = root;
            return  t;
        }
        Node<T> node = new Node<T> (t);
        node.pre = tail;
        tail = node;
        return t;
    }

    public T pop(){
        if(root == null){
            throw new RuntimeException("stack is empty");
        }
        T ret = null;
        if(root == tail){
            ret = root.value;
            root = null;
            tail = null;
            return ret;
        }
        ret = tail.value;
        tail = tail.pre;
        return ret;
    }
    @Override
    public String toString(){
        return tail.toString();
    }


}
