public class LL{
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }
    public void insertfirst(int value){
        Node node= new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertlast(int value){
        if(tail==null) insertfirst(value);
        Node node =new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    public void insert(int value,int index){
        Node temp= head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        size++;
    }
    public Node getvalue(int index){
        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }

    public void deletefirst(){
        if(head==null) return;
       else head=head.next;
        size--;
    }
    public void deletelast(){
        if(size<=1) deletefirst();
        else {
            Node temp=head;
            for (int i = 0; i < size-1; i++) {
                temp= temp.next;
            }
            tail=temp;
            tail.next=null;
            size--;
        }
    }
     public void display(){
        Node temp=head;
         for (int i = 0; i < size; i++) {
             int value=temp.value;
             temp=temp.next;
             System.out.print(value+"->");
         }
         System.out.println("End");
    }
}
 class DLL {
     private Node head;
     private int size;

     void insertfirst(int value) {
         Node node = new Node(value);
         node.next = head;
         if (head != null) head.prev = node;
         head = node;
         node.prev = null;
         size++;
     }

     void indertlast(int value) {
         Node temp;
         temp = head;
         if (head == null) insertfirst(value);
         while (temp.next != null) {
             temp = temp.next;
         }
         Node node = new Node(value);
         temp.next = node;
         node.prev = temp;
         node.next = null;
         size++;
     }

     void deletefirst() {
         head = head.next;
         size--;
     }

     void deletelast() {
         Node temp;
         temp = head;
         while (temp.next.next != null) {
             temp = temp.next;
         }
         temp.next=null;
         size--;
     }

     void display() {
         Node temp;
         temp = head;
         while (temp != null) {
             System.out.print(temp.value+"-->");
             temp=temp.next;
         }
         System.out.println("End");
     }
     void insert(int value, int index){
         if(head==null) insertfirst(value);
         else if(index==size) {indertlast(value);
         }
         Node temp;
         temp=head;
         Node node =new Node(value);
         for (int i = 0; i < index-1; i++) {
           temp=temp.next;
         }
         node.next=temp.next;
         temp.next.prev=node;
         temp.next=node;
         node.prev=temp;
         size++;
     }
