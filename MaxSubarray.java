public class MaxSubarray {

    static int[] maxSubarray(int[] arr) {
        int[] result = new int[2];

        int max = arr[0];
        for (int value : arr) {
            max = Math.max(max, value);
        }
        if (max <= 0) {
            result[0] = max;
            result[1] = max;
            return result;
        }

        result[0] = maxSumSubarray(arr);
        result[1] = maxSumSubsequence(arr);

        return result;
    }

    static int maxSumSubarray(int[] arr) {
        int max = 0;
        int subMax = 0;
        for (int value : arr) {
            if (subMax < 0) {
                subMax = 0;
            }
            subMax += value;
            max = Math.max(max, subMax);
        }
        return max;
    }

    static int maxSumSubsequence(int[] arr) {
        int result = 0;
        for (int value : arr) {
            if (value > 0) {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 2;
        arr[1] = -1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = -5;
        int[] result = maxSubarray(arr);
        for (int value : result) {
            System.out.println(value);
        }
    }

}
