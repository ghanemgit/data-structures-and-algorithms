package Challenge05;


public class LinkedList {

    Node head; //declaration the head of out linked list

    public LinkedList() { //the constructor of linked list
        this.head = null;
    }

    public boolean isEmpty() { //method to check if the linked list empty or not
        return (this.head == null);
    }

    public void insertFirst(int value) {//method to insert value to first of our linked list

        Node newNode = new Node(value);//create new node contain the value
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

    public void insertLast(int value) {
        Node newNode = new Node(value);//create new node contain the value
        if (isEmpty())                   //If the list empty go to insert function and let user insert
            insertFirst(value);
        else {
            Node temp = this.head;  //create new pointer and assign it to head value to start from beginning
            while (temp.next != null) //if we don't reach the end still to move pointer node after node
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
        String string = "";
        while (pointer != null) {
            string += "{ " + pointer.data + " } -> ";
            pointer = pointer.next;
        }
        string += pointer ;
        return string;
    }

    public void insertBefore(int value,int newValue) {
        Node newNode = new Node(newValue);
        Node temp = this.head;
        if (isEmpty() || temp.data == value) {    // check the condition of list if empty or not & the second condition especially created to insert new value before first value in the list
            String s = isEmpty()? "Your linked list is empty please fill it":"";//this line to print out this sentence if list is empty else will print empty string
            System.out.println(s);
            insertFirst(newValue);
        } else if (includes(value)) {
                newNode.data = newValue;
                while (temp.next.data != value) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
        } else {
            System.err.println("Sorry, the number you want insert before is not found");
        }
    }

    public void insertAfter(int value,int newValue ) {


        if (isEmpty()) {
            System.out.println("Your linked list is empty please fill it");
            insertFirst(newValue);
        } else if (includes(value)) {
            Node newNode = new Node();
            newNode.data = newValue;
            Node temp = this.head;

            while (temp != null && temp.data != value) {
                temp = temp.next;
            }
            assert temp != null;
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.err.println("Sorry, the number you want insert before is not found");
        }
    }
}
