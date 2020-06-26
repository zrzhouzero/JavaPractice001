public class Kaprekar {

    static void kaprekarNumbers(int p, int q) {
        StringBuilder builder = new StringBuilder();
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                builder.append(i).append(" ");
            }
        }
        if (builder.length() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            builder.setLength(builder.length() - 1);
            System.out.println(builder.toString());
        }
    }

    static boolean isKaprekar(int num) {
        long square = (long) num * num;
        String squareStr = String.valueOf(square);

        int d = String.valueOf(num).length();
        int split = squareStr.length() == (2 * d) ? d : d - 1;

        String lString = squareStr.substring(0, split);
        String rString = squareStr.substring(split);

        int lInt;
        if (lString.length() == 0) {
            lInt = 0;
        } else {
            lInt = Integer.parseInt(lString);
        }
        int rInt = Integer.parseInt(rString);

        return (lInt + rInt) == num;
    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

}
