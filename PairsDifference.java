import java.util.Arrays;

public class PairsDifference {

    static int pairs(int k, int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i] + k) {
                    res++;
                    break;
                } else if (arr[j] > arr[i] + k) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 4, 6, 2};
        int k = 2;
        System.out.println(pairs(k, arr));
    }

}
