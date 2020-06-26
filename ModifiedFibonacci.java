import java.math.BigInteger;

public class ModifiedFibonacci {

    static String modifiedFibonacci(int t1, int t2, int n) {
        int i = 0;
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        BigInteger c;
        while (i < n - 2) {
            c = a.add(b.multiply(b));
            a = b;
            b = c;
            i++;
            System.out.println(b);
        }
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(modifiedFibonacci(0, 1, 10));
    }

}
