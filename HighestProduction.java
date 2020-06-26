public class HighestProduction {

    public static int highestProduction(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int currentHighest = 0;

        while (start <= end) {
            int sum = 0;
            int height = nums[start];
            for (int i = start; i <= end; i++) {
                sum += nums[i];
                if (nums[i] < height) {
                    height = nums[i];
                }
            }
            int temp = sum * height;
            currentHighest = Math.max(temp, currentHighest);
            if (nums[start] < nums[end]) {
                start++;
            } else {
                end--;
            }
        }

        return currentHighest;
    }

    public static void main(String[] args) {
        int[] input = {13,7,9,9,9};
        System.out.println(highestProduction(input));
    }

}
