import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        if (nums.length <= 1) return new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int length = max - min + 1;
        int[] temp = new int[length];

        for (int num : nums) {
            temp[num - min]++;
        }

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 1) {
                resultList.add(min + i);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        ArrayList<Integer> result = (ArrayList<Integer>) findDuplicates(input);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

}
