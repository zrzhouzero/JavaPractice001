import java.util.ArrayList;

public class LongestDecomposition {

    public static int longestDecomposition(String text) {

        int length = text.length();
        int leftStartIndex = 0;
        int leftEndIndex = 1;
        int rightStartIndex = length - leftEndIndex;
        int rightEndIndex = length - leftStartIndex;

        ArrayList<Boolean> result = new ArrayList<>();

        while (leftEndIndex <= length / 2) {
            String strA = text.substring(leftStartIndex, leftEndIndex);
            String strB = text.substring(rightStartIndex, rightEndIndex);
            if (strA.equals(strB)) {
                result.add(true);
                leftStartIndex = leftEndIndex;
                leftEndIndex = leftStartIndex + 1;
                rightStartIndex = length - leftEndIndex;
                rightEndIndex = length - leftStartIndex;
            } else {
                leftEndIndex++;
                rightStartIndex--;
            }
        }

        if (result.size() == 0) {
            return 1;
        }

        if (result.contains(false)) {
            return 1;
        } else {
            if (leftStartIndex == rightEndIndex) {
                return result.size() * 2;
            } else {
                return result.size() * 2 + 1;
            }
        }

    }

    public static void main(String[] args) {
        String text = "aaa";
        int i = longestDecomposition(text);
        System.out.println(i);
    }

}
