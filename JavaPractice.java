import java.util.*;

public class JavaPractice {

    public static void run1(String input) {
        Stack<String> stringStack = new Stack<>();
        stringStack.add(input.substring(0, 1));
        for (int i = 1; i < input.length(); i++) {
            if (stringStack.isEmpty()) {
                stringStack.add(input.substring(i, i + 1));
                continue;
            }
            if (
                    (stringStack.peek().equals("(") && input.substring(i, i + 1).equals(")")) ||
                    (stringStack.peek().equals("{") && input.substring(i, i + 1).equals("}")) ||
                    (stringStack.peek().equals("[") && input.substring(i, i + 1).equals("]"))
            ) {
                stringStack.pop();
            } else {
                stringStack.add(input.substring(i, i + 1));
            }
        }

        if (stringStack.isEmpty()) {
            System.out.println("TRUE");
        } else System.out.println("FALSE");
    }

    static class StringPair implements Comparable<StringPair>{
        private String str1;
        private String str2;

        StringPair(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        @Override
        public int compareTo(StringPair o) {
            if (this.str1.equals(o.str1) && this.str2.equals(o.str2)) {
                return 0;
            } else {
                return this.str1.compareTo(o.str1);
            }
        }
    }

    public static void incrementMap(HashMap<Integer, Integer> map, Integer i) {
        if (map.containsKey(i)) {
            int num = map.get(i);
            num += 1;
            map.put(i, num);
        } else {
            map.put(i, 1);
        }
    }

    public static void decrementMap(HashMap<Integer, Integer> map, Integer i) {
        if (!map.containsKey(i)) {
            return;
        }
        if (map.get(i) == 1) {
            map.remove(i);
        } else {
            int num = map.get(i);
            num -= 1;
            map.put(i, num);
        }
    }

    public static void run2() {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int largest = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (deque.size() < m) {
                incrementMap(map, num);
                deque.add(num);
            } else if (deque.size() == m) {
                decrementMap(map, deque.getFirst());
                deque.removeFirst();
                deque.add(num);
                incrementMap(map, num);
            }
            if (deque.size() == m) {
                largest = Math.max(map.size(), largest);
            }
        }

        System.out.println(largest);
    }

    public static <T> void printArray(T[] ele) {
        for (T element : ele) {
            if (element instanceof Integer) {
                System.out.println(element);
            } else if (element instanceof String) {
                System.out.println(element);
            } else {
                System.out.println("not string or number");
            }
        }
    }

    public static void main(String[] args) {
        run2();
    }

}
