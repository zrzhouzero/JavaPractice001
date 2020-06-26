import java.util.HashSet;

public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;
        HashSet<Integer> kSet = new HashSet<>();
        kSet.add(k);
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                int sum = ar[i] + ar[j];
                if (kSet.contains(sum)) {
                    result += 1;
                } else {
                    if ((sum % k) == 0) {
                        kSet.add(sum);
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};

        System.out.println(divisibleSumPairs(n, k, ar));
    }

}
