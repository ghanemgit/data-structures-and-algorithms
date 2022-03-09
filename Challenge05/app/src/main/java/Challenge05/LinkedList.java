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
        string += pointer;
        return string;
    }

    public void insertBefore(int value, int newValue) {
        Node newNode = new Node(newValue);
        Node temp = this.head;
        /*
        check the condition of list if empty or not &
        the second condition especially created to insert new value before first value in the list
        */
        if (isEmpty() || temp.data == value) {

            //this line to print out this sentence if list is empty else will print empty string
            String s = isEmpty() ? "Your linked list is empty please fill it" : "";
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

    public void insertAfter(int value, int newValue) {


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

    public int kthFromEnd(int k) {

        int result = 0;//this variable to store the answer
        int counter = 0;//this counter to know how much item in our linked list(size or length)
        int secondCounter = 0;
        /*
        when this new counter is reach the k value that will work to stop the loop and let us take the result,
        That done by simple expression (counter - newCounter) must equal the k value to stop looping.
         */


        //If the list empty go to insert function and let user insert
        if (isEmpty())
            System.out.println("Sorry the linked list is empty");

        else if (k >= 0) {
            //create new pointer and assign it to head value to start from beginning
            Node pointer = this.head;

            /*
            if we don't reach the end still to move pointer node after node, Meanwhile increase the counter by
            one each loop to determine the numbers of item we have in our linked list
             */
            while (pointer.next != null) {
                counter++;
                pointer = pointer.next;
            }

            if (k > counter)
                System.err.println("Sorry the number you try to get out of range");
            else if (k == 0)
                result = pointer.data;//because the last value for pointer after finish the loop, is the last one in linked list
            else {
                pointer = this.head;//return the pointer to start(head) point
                while ((counter - secondCounter) != k) {
                    secondCounter++;

                    pointer = pointer.next;
                }
                result = pointer.data;
            }
        } else {
            System.out.println("Sorry, you entered negative number");
        }

        return result;
    }


    public String zipLists(LinkedList a, LinkedList b) {

        LinkedList result = new LinkedList();//create linked list to store the result
        Node pointerA = a.head;//create new node to first list
        Node pointerB = b.head;//create new node to second list

        while (pointerA != null || pointerB != null) {//check if pointer not reach the end

                if (pointerA != null && pointerB != null) {//check if both list has next value
                    result.insertLast(pointerA.data);//add the value of this node to result list, from list a
                    result.insertLast(pointerB.data);//add the value of this node to result list, from list b
                    pointerA = pointerA.next;//move straight ahead
                    pointerB = pointerB.next;
                }
                else if (pointerA != null){//if list a still has node please continue  without work on other list because its at the end.
                    result.insertLast(pointerA.data);
                    pointerA = pointerA.next;
                }
                else {//if list b still has node please continue  without work on other list because its at the end.
                    result.insertLast(pointerB.data);
                    pointerB = pointerB.next;
                }
        }
        return result.to_string();
    }
//    public void insertAfter(int value, int newValue) {
//
//
//        if (isEmpty()) {
//            System.out.println("Your linked list is empty please fill it");
//            insertFirst(newValue);
//        } else if (includes(value)) {
//            Node newNode = new Node();
//            newNode.data = newValue;
//            Node temp = this.head;
//
//            while (temp != null && temp.data != value) {
//                temp = temp.next;
//            }
//            assert temp != null;
//            newNode.next = temp.next;
//            temp.next = newNode;
//        } else {
//            System.err.println("Sorry, the number you want insert before is not found");
//        }
//    }
}
