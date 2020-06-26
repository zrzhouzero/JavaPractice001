import java.util.ArrayList;

public class LeonardosPrimeFactors {

    static ArrayList<Integer> primeNumbers;
    static int index;

    static void initMap() {
        primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        index = 1;
    }

    static void generateNextPrime() {
        int num = primeNumbers.get(index);
        boolean add = false;
        while (!add) {
            num += 2;
            if (isPrime(num)) {
                primeNumbers.add(num);
                index++;
                add = true;
            }
        }
    }

    static boolean isPrime(int num) {
        boolean prime = true;
        int i = 0;
        while (num / primeNumbers.get(i) >= primeNumbers.get(i)) {
            if (num % primeNumbers.get(i) == 0) {
                prime = false;
                break;
            }
            i++;
        }
        return prime;
    }

    static int primeCount(long n) {
        if (n == 1) {
            return 0;
        }
        initMap();
        long m = 1;
        int i = 0;
        while (m <= n) {
            m *= primeNumbers.get(i);
            i++;
            if (m < 0) {
                break;
            }
            if (i > index) {
                generateNextPrime();
            }
        }
        i -= 1;
        return i;
    }

    public static void main(String[] args) {
        long n = 614889782588491410L;
        System.out.println(primeCount(n));
    }

}
