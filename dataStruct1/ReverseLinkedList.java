package dataStruct1;

public class ReverseLinkedList {
    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            next=null;
        }
    }
    Node head;
    void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    void display(Node head){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print(temp.val);
    }
    Node ReverseList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = ReverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next=null;
        return newHead;
    }
    public static void main(String args[]){
        ReverseLinkedList list = new ReverseLinkedList();
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.display(list.head);       
        list.head = list.ReverseList(list.head);
        System.out.println();
        list.display(list.head);
    }
}

