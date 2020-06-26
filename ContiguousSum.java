import java.util.ArrayList;
import java.util.List;

public class ContiguousSum {

    public static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        for (int i = 0; i < s.size() - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        /*list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);*/
        list.add(4);
        int d = 4;
        int m = 1;
        System.out.println(birthday(list, d, m));
    }

}
