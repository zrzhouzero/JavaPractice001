public class Sort {

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private static int minimumSwap(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while (left < right) {
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
                count++;
            }
            int lDif = Math.abs(arr[left] - arr[left + 1]);
            int rDif = Math.abs(arr[right] - arr[right - 1]);
            if (lDif >= rDif) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1};
        System.out.println(minimumSwap(arr));
    }

}
