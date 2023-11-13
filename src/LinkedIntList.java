// LinkedIntList.java
// Represents a list of integers.
public class LinkedIntList {

    private ListNode front;
    private int size;

    public void add(int index, int value) {
        if (index > size) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            ListNode temp = new ListNode(value, front);
            front = temp;
        } else {
            ListNode curr = front;
            while (index > 1) {
                curr = curr.next;
                index--;
            }
            ListNode temp = new ListNode(value, curr.next);
            curr.next = temp;
        }
        size++;
    }

    // post: constructs an empty LinkedIntList
    public LinkedIntList() {
        this(null);
    }

    // post: constructs a LinkedIntList from the given int[] nums
    //       constructs an empty LinkedIntList if nums is null or has a size of 0
    public LinkedIntList(int[] nums) {
        this.size = 0;
        if (nums == null || nums.length == 0) {
            this.front = null;
        } else {
            for (int i = 0; i < nums.length; i++) {
                this.add(nums[i]);
            }
        }
    }

    // post: Adds the given value to the end of this list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
        this.size++;
    }

    // post: returns a String representation of the contents of the list in one line,
    //       separated by spaces
    public String toString() {
        String listString = "";
        ListNode current = front;
        while (current != null) {
            listString += current.data + " ";
            current = current.next;
        }
        return listString;
    }

    // post: returns the number of elements in the list
    public int size() {
        return this.size;
    }

    // post: returns the value of the element at the given int index of the list
    //       throws an IllegalArgumentException if the index is out of bounds
    public int get(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("not a valid index!");
        }
        ListNode curr = this.front;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // Inner class that represents a single node containing an
    // integer value.
    public static class ListNode {
        public final int data;
        public ListNode next;

        // Constructs a ListNode with the given data
        public ListNode(int data) {
            // Sets the next field to null, meaning there
            // is no next linked node.
            this(data, null);
        }

        // Constructs a ListNode with the given data
        // and given next node.
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}