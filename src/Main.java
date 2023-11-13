import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = createList(10);
        printList(list);

        IntSearchTree root = new IntSearchTree();
        root.addRand(8);

        LinkedIntList lList = new LinkedIntList();
        addRand(lList, 8);

        Set<Integer> set = new TreeSet<>();
        fillSet(set, 4);

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        fillQueue(queue, 5);
        fillStack(stack, 5);


        System.out.println("da");

    }

    public static List<Integer> createList(int size){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            list.add(random);
        }
        return list;
    }
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + ", ");
        }
    }
    public static void addRand(LinkedIntList l, int size) {
        for(int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            l.add(random);
        }
    }

    public static void fillSet(Set<Integer> set, int size) {
        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            set.add(random);
        }
    }

    public static void fillStack(Stack<Integer> set, int size) {
        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            set.add(random);
        }
    }
    public static void fillQueue(Queue<Integer> set, int size) {
        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            set.add(random);
        }
    }

}

