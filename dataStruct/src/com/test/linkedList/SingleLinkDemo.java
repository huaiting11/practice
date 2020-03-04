package com.test.linkedList;

public class SingleLinkDemo {
    public static void main(String[] args) {

    }
}
// 定义SingleLink
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    /**
     * 添加节点到单项链表、
     * 思路，当不考虑编号顺序时。
     * 1.找到当前链表的最后及诶点
     * 2.将最后这个节点的next，指向新的节点
     */
    public void add(){

    }

}

//节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
