import java.util.ArrayList;

public class CoinPickProblem {

    private static class CoinRecorder {

        private int value;
        private ArrayList<Integer> indices;

        private CoinRecorder(int value, ArrayList<Integer> indices) {
            this.value = value;
            this.indices = indices;
        }

        @Override
        public String toString() {
            StringBuilder indexBuilder = new StringBuilder();
            indexBuilder.append("[");
            for (Integer i : indices) {
                indexBuilder.append(i).append(" ");
            }
            indexBuilder.deleteCharAt(indexBuilder.length() - 1);
            indexBuilder.append("]");
            return value + " " + indexBuilder.toString();
        }
    }

    public static int largestCoinValue(int[] inputArray) {

        int val1 = inputArray[0];
        int val2 = Math.max(inputArray[0], inputArray[1]);
        int index = 2;
        boolean b = true;

        while (index < inputArray.length) {
            if (b) {
                val1 = val1 + inputArray[index];
                val1 = Math.max(val1, val2);
            } else {
                val2 = val2 + inputArray[index];
                val2 = Math.max(val1, val2);
            }
            index++;
            b = !b;
        }

        return Math.max(val1, val2);

    }

    /**
     *
     * @param i the last index
     * @param inputArray the InsertRankingInput array
     * @return the max value
     */
    public static int largestCoinValue2(int i, int[] inputArray) {

        if (i == 0) return inputArray[0];
        if (i == 1) return Math.max(inputArray[0], inputArray[1]);

        return Math.max(largestCoinValue2(i - 1, inputArray), largestCoinValue2(i - 2, inputArray) + inputArray[i]);

    }

    public static void main(String[] args) {
        int[] array = {5, 2, 10, 2, 6, 3, 4};
        int result = largestCoinValue(array);
        int result2 = largestCoinValue2(array.length - 1, array);
        System.out.println(result);
        System.out.println(result2);
    }

}
