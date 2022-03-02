package Challenge05;


public class LinkedList {

    Node head; //declaration the head of out linked list

    public LinkedList() { //the constructor of linked list
        this.head = null;
    }

    public boolean isEmpty() { //method to check if the linked list empty or not
        return (this.head == null);
    }

    public void insertFirst(int value) {//method to insert value to our linked list

        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    public boolean includes(int value) {
        boolean bool = false;
        Node pointer = this.head;
        while (pointer != null) {

            if (pointer.data == value) {
                bool = true;
                break;
            }

            pointer = pointer.next;

        }
        return bool;
    }
    public void insertLast(int value){
        Node newNode = new Node(value);
        if(isEmpty())
            insertFirst(value);
        else {
            Node temp = this.head;
            while (temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = null;
        }
    }

    public String to_string() {
        //"{ a } -> { b } -> { c } -> NULL"

        Node pointer = this.head;
        String string = "\"";
        while (pointer != null) {
            string += "{ " + pointer.data + " } -> ";
            pointer = pointer.next;
        }
        string += pointer + "\"";
        return string;
    }
}
