import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InsertRanking {

    public static int[] insertNum(int[] array, int num) {
        int length = array.length;
        int[] newArray = new int[length + 1];
        int numIndex = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            if (num <= array[i]) {
                numIndex = i + 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < newArray.length; j++) {
            if (j <= numIndex - 1) {
                newArray[j] = array[j];
            } else if (j == numIndex) {
                newArray[j] = num;
            } else {
                newArray[j] = array[j - 1];
            }
        }
        return newArray;
    }

    public static int getRank(int[] array, int num) {
        int[] newArray = insertNum(array, num);
        List<Integer> rankList = new ArrayList<>();
        for (int i : newArray) {
            if (!rankList.contains(i)) {
                rankList.add(i);
            }
        }
        return rankList.indexOf(num) + 1;
    }

    public static int[] getRank2(int[] array, int[] nums) {
        int[] result = new int[nums.length];
        HashSet<Integer> bucket = new HashSet<>();
        int index = nums.length - 1;

        int i = 0;
        while (i < array.length) {
            if (nums[index] >= array[i]) {
                result[index] = bucket.size() + 1;
                index--;
                if (index < 0) {
                    break;
                }
            } else {
                bucket.add(array[i]);
                i++;
            }
        }

        if (result[0] == 0) {
            result[0] = bucket.size() + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        File file = new File("src/InsertRankingInput");
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            int i = scanner.nextInt();
            int[] arr = new int[i];
            for (int index = 0; index < i; index++) {
                arr[index] = scanner.nextInt();
            }
            int j = scanner.nextInt();
            int[] num = new int[j];
            for (int index = 0; index < j; index++) {
                num[index] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(getRank2(arr, num)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
