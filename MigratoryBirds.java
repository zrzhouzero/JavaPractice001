import java.util.List;

public class MigratoryBirds {

    private static int migratoryBirds(List<Integer> arr) {
        int[] nums = new int[5];
        for (Integer i : arr) {
            nums[i - 1]++;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < 5; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {

    }

}
