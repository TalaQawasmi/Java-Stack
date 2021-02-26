    public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList(){
        this.head =null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value){
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        Node current = head;
        while(current.next != null){
            if(current.next.next == null){
                current.next = null;
            }
            else{
                current = current.next;
            }
        }
    }
    public void print(){
        Node pointer= head;
        while (pointer != null){
            System.out.print(pointer.value + "->");
            pointer = pointer.next;
        }
    }  
}