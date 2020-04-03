package stack;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayStack <T> {
    private  Object[] a;
    private int size;
    private int top;
    public ArrayStack(int maxSize){
        this.size = maxSize;
        this.a = new Object[size];
        this.top = -1;
    }
    public void push(T value){
        if(isFull()){
            System.out.println("栈已经满！");
            return;
        }
        a[++top] = value;
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("栈中没有数据！");
        }
        return  (T)a[top];
    }
    //弹出栈顶内容，删除
    public T pop(){
        if(isEmpty()){
            System.out.println("栈中没有数据！");

        }
        return (T)a[top--];
    }
    public int size(){
        return top + 1;
    }

    //是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //是否满了
    public boolean isFull() {
        return (top == size - 1);
    }
    public void display(){
        System.out.print("[");
        for (int i = top; i >=0 ; i--) {
            System.out.print(a[i].toString());
            if(i!=0){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.display();
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.isFull());
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.display();
        arrayStack.peek();
        arrayStack.pop();
        arrayStack.display();
    }


}
