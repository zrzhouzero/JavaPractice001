public class Encrypt {

    private static String encrypt(String origin) {
        origin = origin.replace(" ", "");

        int row = (int) Math.sqrt(origin.length());
        int column = (int) Math.sqrt(origin.length());

        if ((row * column) < origin.length()) {
            column++;
        }

        if ((row * column) < origin.length()) {
            row++;
        }

        String[] strings = new String[row];

        int i;

        for (i = 0; i < row - 1; i++) {
            strings[i] = origin.substring(column * i, column * i + column);
        }

        strings[row - 1] = origin.substring(column * i);

        String[] newStrings = new String[column];

        for (int j = 0; j < column; j++) {
            StringBuilder builder = new StringBuilder();
            try {
                for (int k = 0; k < row; k++) {
                    builder.append(strings[k], j, j + 1);
                }
            } catch (Exception ignore) {
            }
            newStrings[j] = builder.toString();
        }

        StringBuilder builder = new StringBuilder();
        for (String s : newStrings) {
            builder.append(s).append(" ");
        }

        builder.setLength(builder.length() - 1);

        return builder.toString();
    }

    private static String nextLexicographical(String origin) {
        int pivot;
        for (pivot = origin.length() - 1; pivot >= 1; pivot--) {
            if (origin.charAt(pivot) > origin.charAt(pivot - 1)) {
                break;
            }
        }
        pivot -= 1;
        if (pivot < 0) {
            return "no answer";
        } else {
            int successor = origin.length() - 1;
            while (origin.charAt(successor) < origin.charAt(pivot)) {
                successor--;
            }

            origin = swap(origin, pivot, successor);

            StringBuilder leftBuilder = new StringBuilder(origin.substring(0, pivot + 1));
            StringBuilder rightBuilder = new StringBuilder(origin.substring(pivot + 1));

            rightBuilder.reverse();
            leftBuilder.append(rightBuilder);

            return leftBuilder.toString();
        }
    }

    private static String swap(String str, int i, int j) {
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1);
    }

    public static void main(String[] args) {
        // String s = "if man was meant to stay on the ground god would have given us roots";
        // System.out.println(encrypt(s));

        String s = "biehzcmjckznhwrfgglverxsezxuqpj";
        System.out.println(nextLexicographical(s));
    }

}
