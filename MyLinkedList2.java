class Node{
    public Node next;
    public int val;
    //默认构造方法
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    //打印链表
    public void disPlay(){
        Node ret = this.head;
        while(ret != null){

            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

    //判断是链表空否
    public boolean isFull(){
        if(this.head == null){
            return true;
        }
        return false;
    }


    //求链表长度
    public int size(){
        int count = 0;
        Node ret = this.head;
        while(ret != null){
            ret = ret.next;
            count++;
        }
        return count;
    }



    //头插法
    public void headInset(int val){
        Node nod = new Node(val);//创建新节点
        if(isFull()){
            this.head = nod;
        }else{
            nod.next = this.head;
            this.head = nod;
        }
    }

    //尾插法
    public void tailInsert(int val){
        Node nod = new Node(val);
        if(isFull()){
            this.head = nod;
        }else{
            Node ret = this.head;
            while(ret.next != null){
                ret = ret.next;
            }
            ret.next = nod;
        }
    }

    //n位置插进去
    public void nInsert(int n,int val){
        Node nod = new Node(val);
        if(isFull()){
            this.head = nod;
        }
        if(n - 1 < 0 || n > size()){
            System.out.println("n值不合法！");
            return;
        }
        if(n- 1 == 0){
            headInset(val);//头插法
            return;
        }
        if(n == size()){
            tailInsert(val);//尾插法
            return;
        }
        Node ret = this.head;
        int count = 1;
        while((n - 1) != count){
            ret = ret.next;
            count++;
        }
        nod.next = ret.next;
        ret.next = nod;
    }

    //删除出现的key值
    public void remove(int key){
        if(isFull()){
            return;
        }
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        Node ret = this.head;
        while(ret.next != null){
            if(ret.next.val == key){
                ret.next = ret.next.next;
                break;
            }
            ret = ret.next;
        }

    }

    //删除出现key的所有值
    public void removeAll(int key){
        if(isFull()){
            return;
        }
        Node prev = this.head;
        Node ret = prev.next;
        while(ret != null){
            if(ret.val == key){
                prev.next = ret.next;
            }else{
                prev = ret;
            }
            ret = ret.next;
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
    }

 public Node head;//头节点
    //创建链表
    public void creatList(){
        this.head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    public static void main(String[] args){
        MyLinkedList myList = new MyLinkedList();
        myList.creatList();//创建链表
        myList.disPlay();//打印链表
        System.out.println();//换行
 myList.nInsert(1,22);//任意插入
        myList.nInsert(3,22);
        myList.nInsert(5,22);
        myList.nInsert(6,22);
        myList.disPlay();//打印链表
        System.out.println();//换行
        myList.remove(22);
        myList.disPlay();//打印链表
        System.out.println();//换行
        myList.removeAll(22);//删除所有key的值
        myList.disPlay();//打印链表
    }
}
