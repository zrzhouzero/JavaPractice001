import java.io.*;
import java.util.Scanner;

public class QueensAttack {

    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        Pair topBound = new Pair(n + 1, c_q);
        Pair rightBound = new Pair(r_q, n + 1);
        Pair bottomBound = new Pair(0, c_q);
        Pair leftBound = new Pair(r_q, 0);

        int r, c;

        r = r_q;
        c = c_q;
        while (r <= n && c <= n) {
            r++;
            c++;
        }
        Pair topRightBound = new Pair(r, c);

        r = r_q;
        c = c_q;
        while (r <= n && c >= 1) {
            r++;
            c--;
        }
        Pair topLeftBound = new Pair(r, c);

        r = r_q;
        c = c_q;
        while (r >= 1 && c <= n) {
            r--;
            c++;
        }
        Pair bottomRightBound = new Pair(r, c);

        r = r_q;
        c = c_q;
        while (r >= 1 && c >= 1) {
            r--;
            c--;
        }
        Pair bottomLeftBound = new Pair(r, c);

        if (k != 0) {
            for (int[] obstacle : obstacles) {
                int rDif = obstacle[0] - r_q;
                int cDif = obstacle[1] - c_q;
                if (rDif == 0 && cDif > 0) {
                    rightBound.c = Math.min(obstacle[1], rightBound.c);
                } else if (rDif == 0 && cDif < 0) {
                    leftBound.c = Math.max(obstacle[1], leftBound.c);
                } else if (cDif == 0 && rDif > 0) {
                    topBound.r = Math.min(obstacle[0], topBound.r);
                } else if (cDif == 0 && rDif < 0) {
                    bottomBound.r = Math.max(obstacle[0], bottomBound.r);
                } else if (rDif == cDif) {
                    if (rDif > 0) {
                        topRightBound.r = Math.min(obstacle[0], topRightBound.r);
                        topRightBound.c = Math.min(obstacle[1], topRightBound.c);
                    } else {
                        bottomLeftBound.r = Math.max(obstacle[0], bottomLeftBound.r);
                        bottomLeftBound.c = Math.max(obstacle[1], bottomLeftBound.c);
                    }
                } else if (rDif == -cDif) {
                    if (rDif < 0) {
                        bottomRightBound.r = Math.max(obstacle[0], bottomRightBound.r);
                        bottomRightBound.c = Math.min(obstacle[1], bottomRightBound.c);
                    } else {
                        topLeftBound.r = Math.min(obstacle[0], topLeftBound.r);
                        topLeftBound.c = Math.max(obstacle[1], topLeftBound.c);
                    }
                }
            }
        }


        System.out.println(topBound);
        System.out.println(topRightBound);
        System.out.println(rightBound);
        System.out.println(bottomRightBound);
        System.out.println(bottomBound);
        System.out.println(bottomLeftBound);
        System.out.println(leftBound);
        System.out.println(topLeftBound);


        int sum = 0;

        sum += topBound.r - r_q - 1;
        System.out.println(sum);

        sum += topRightBound.r - r_q - 1;
        System.out.println(sum);

        sum += rightBound.c - c_q - 1;
        System.out.println(sum);

        sum += bottomRightBound.c - c_q - 1;
        System.out.println(sum);

        sum += r_q - bottomBound.r - 1;
        System.out.println(sum);

        sum += r_q - bottomLeftBound.r - 1;
        System.out.println(sum);

        sum += c_q - leftBound.c - 1;
        System.out.println(sum);

        sum += c_q - topLeftBound.c - 1;
        System.out.println(sum);

        return sum;
    }

    /*
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 5;
        obstacles[0][1] = 5;
        obstacles[1][0] = 4;
        obstacles[1][1] = 2;
        obstacles[2][0] = 2;
        obstacles[2][1] = 3;
        int sum = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(sum);
    }
    */

    public static void main(String[] args) throws IOException {

        File file = new File("src/QueensAttackInput");
        Scanner scanner = new Scanner(new FileReader(file));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }

}
