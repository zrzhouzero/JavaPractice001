public class CountBits {

    public static int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }

        int[] sample = {0};

        while (sample.length < num + 1) {
            int[] extend = new int[sample.length];
            for (int i = 0; i < sample.length; i++) {
                extend[i] = sample[i] + 1;
            }
            int[] newSample = new int[sample.length * 2];
            for (int i = 0; i < sample.length; i++) {
                newSample[i] = sample[i];
                newSample[i + sample.length] = extend[i];
            }
            sample = newSample;
        }

        int[] result = new int[num + 1];
        System.arraycopy(sample, 0, result, 0, result.length);
        return result;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = countBits(2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
