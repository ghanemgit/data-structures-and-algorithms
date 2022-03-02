/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Challenge05;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int value;
        /* Note: you can use insertLast() method to insert number at last and at first only if your linked list is empty
                 otherwise you have to use insertFirst() method to insert at the first whenever you want.
         */

        for (int i = 0; i < 4; i++) {
            System.out.println("Is the linked list empty => "+list.isEmpty());
            System.out.println("Please enter a number to add to linked list");
            value = input.nextInt();
            list.insertFirst(value);
        }

        System.out.println("Please enter a number to check if added to linked list");
        int value2 = input.nextInt();
        String s = list.includes(value2)? "The number added":"The number is not found";
        System.out.println(s);
        input.close();
        System.out.println("Your linked list is => "+list.to_string());
    }
}
