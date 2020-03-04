package com.test.linkedList;

import com.sun.xml.internal.ws.api.message.HeaderList;

import java.util.LinkedList;

public class SingleLinkDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1,"宋江","宋江");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","卢俊义");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode);
        singleLinkedList.add(heroNode2);
        singleLinkedList.list();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        String sql ="INSERT INTO `user` VALUES(NULL,?,?,?,?,?,?,NULL,NULL)";


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
    public void add(HeroNode node){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;

        }
        // 当退出while 循环时，temp 就指向了链表的最后
        temp.next = node;
    }
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            // 判断是否到链表最后
            if(temp == null){
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp 后移，
            temp= temp.next;
        }
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
                '}';
    }
}
