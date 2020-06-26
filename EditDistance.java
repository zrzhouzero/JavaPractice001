public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int[][] temp = new int[word1.length() + 1][word2.length() + 1];
        temp[0][0] = 0;
        for (int i = 1; i < temp.length; i++) {
            temp[i][0] = i;
        }
        for (int i = 1; i < temp[0].length; i++) {
            temp[0][i] = i;
        }
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1];
                } else {
                    temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
                }
            }
        }
        return temp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));

    }

}