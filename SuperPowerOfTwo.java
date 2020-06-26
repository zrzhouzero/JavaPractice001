public class SuperPowerOfTwo {

    static int solve(int a, int b) {
        if (a == 0) {
            return 2;
        } else return ((solve(a - 1, b) % b) * (solve(a - 1, b) % b)) % b;
    }

    static int solve2(int a, int b) {
        if (a == 0) {
            return 2 % b;
        }
        if (a == 1) {
            return 4 % b;
        }
        double result = 4 % b;
        for (int i = 2; i <= a; i++) {
            result = ((result % b) * (result % b)) % b;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(solve2(261887, 573440));
    }

}
