/*
* 你可以选择使用单链表或者双链表，设计并实现自己的链表。
单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
实现 MyLinkedList 类：
* 那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。*/

import java.awt.*;

public class lc707_MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//        System.out.println(myLinkedList.get(1)); // 返回 3
        myLinkedList.addAtHead(1);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3,0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(3);
//        myLinkedList.get(4);
//        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(3,2);
//        myLinkedList.addAtHead(6);


    }
    static void printLinkedList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class MyLinkedList {
    static int size = 0; // 链表节点总数
    ListNode head; // 链表的头节点

    // MyLinkedList() 初始化 MyLinkedList 对象。
    public MyLinkedList() {
        size = 0; // 初始化节点数为0
        head = new ListNode(0); // 头节点，不算入节点数
    }

    // int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
    public int get(int index) {
        if(index<0 || index>size-1)
            return -1;
        ListNode curNode = head;
        for(int i=0;i<=index;i++){
            curNode = curNode.next;
        }
        return curNode.val;
    }

    // void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if(head.next == null)
            head.next = newNode;
        else {
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    // void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode curNode = head;
        for(int i=0;i<size;i++)
            curNode = curNode.next;
        curNode.next = newNode;
        size++;
    }

    // void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        ListNode curNode = head;
        ListNode newNode = new ListNode(val);
        for(int i=0;i<index;i++)
            curNode = curNode.next;
        newNode.next = curNode.next;
        curNode.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>size-1)
            return;
        ListNode curNode = head;
        for(int i=0;i<index;i++)
            curNode = curNode.next;
        if(curNode.next.next == null)
            curNode.next = null;
        else
            curNode.next = curNode.next.next;
        size--;
    }
}

