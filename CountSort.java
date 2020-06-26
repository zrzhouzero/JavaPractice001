import java.util.ArrayList;
import java.util.List;

public class CountSort {

    static void countSort(List<List<String>> arr) {
        List<List<String>> result = new ArrayList<>();

        int max = 0;
        for (List<String> strings : arr) {
            int temp = Integer.parseInt(strings.get(0));
            max = Math.max(temp, max);
        }

        for (int i = 0; i <= max; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.size() / 2; i++) {
            int integer = Integer.parseInt(arr.get(i).get(0));
            result.get(integer).add("-");
        }

        for (int i = arr.size() / 2; i < arr.size(); i++) {
            int integer = Integer.parseInt(arr.get(i).get(0));
            String str = arr.get(i).get(1);
            result.get(integer).add(str);
        }

        StringBuilder builder = new StringBuilder();
        for (List<String> list : result) {
            for (String s : list) {
                builder.append(s).append(" ");
            }
        }
        builder.setLength(builder.length() - 1);

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("ab");

        List<String> list2 = new ArrayList<>();
        list2.add("6");
        list2.add("cd");

        List<String> list3 = new ArrayList<>();
        list3.add("0");
        list3.add("ef");

        List<String> list4 = new ArrayList<>();
        list4.add("6");
        list4.add("gh");

        List<String> list5 = new ArrayList<>();
        list5.add("4");
        list5.add("ij");

        List<String> list6 = new ArrayList<>();
        list6.add("0");
        list6.add("ab");

        List<String> list7 = new ArrayList<>();
        list7.add("6");
        list7.add("cd");

        List<String> list8 = new ArrayList<>();
        list8.add("0");
        list8.add("ef");

        List<String> list9 = new ArrayList<>();
        list9.add("6");
        list9.add("gh");

        List<String> list10 = new ArrayList<>();
        list10.add("0");
        list10.add("ij");

        List<String> list11 = new ArrayList<>();
        list11.add("4");
        list11.add("that");

        List<String> list12 = new ArrayList<>();
        list12.add("3");
        list12.add("be");

        List<String> list13 = new ArrayList<>();
        list13.add("0");
        list13.add("to");

        List<String> list14 = new ArrayList<>();
        list14.add("1");
        list14.add("be");

        List<String> list15 = new ArrayList<>();
        list15.add("5");
        list15.add("question");

        List<String> list16 = new ArrayList<>();
        list16.add("1");
        list16.add("or");

        List<String> list17 = new ArrayList<>();
        list17.add("2");
        list17.add("not");

        List<String> list18 = new ArrayList<>();
        list18.add("4");
        list18.add("is");

        List<String> list19 = new ArrayList<>();
        list19.add("2");
        list19.add("to");

        List<String> list20 = new ArrayList<>();
        list20.add("4");
        list20.add("the");

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        lists.add(list6);
        lists.add(list7);
        lists.add(list8);
        lists.add(list9);
        lists.add(list10);
        lists.add(list11);
        lists.add(list12);
        lists.add(list13);
        lists.add(list14);
        lists.add(list15);
        lists.add(list16);
        lists.add(list17);
        lists.add(list18);
        lists.add(list19);
        lists.add(list20);

        countSort(lists);
    }

}
