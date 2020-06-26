import java.util.ArrayList;
import java.util.HashSet;

public class PrimeSetOperation {

    private static HashSet<Integer> primeNumberSet;
    private static int currentLargestPrimeNumber;

    public static void initialiseSet() {
        primeNumberSet = new HashSet<>();
        primeNumberSet.add(2);
        primeNumberSet.add(3);
        currentLargestPrimeNumber = 3;
    }

    public static void main(String[] args) {
        initialiseSet();
        long totalTime = 0;
        long firstRun = 0;
        int op = 0;
        int inputNumber = 3149857;
        System.out.println("InsertRankingInput number: " + inputNumber);
        for (int i = 0; i < 10; i++) {
            long time1 = System.nanoTime();
            op = operations(inputNumber);
            long time2 = System.nanoTime();
            totalTime += time2 - time1;
            if (i == 0) {
                firstRun = totalTime;
                System.out.println("first run time: " + firstRun);
            }
        }
        System.out.println("rest runs time: " + (totalTime - firstRun));
        System.out.println("total run time: " + totalTime);
        System.out.println("operations: " + op);
    }

    public static int operations(int num) {
        while (num > currentLargestPrimeNumber) {
            addPrimeNumber();
        }
        ArrayList<Integer> list = getAllPrimeFactors(num);
        return list.size() - 1 + list.get(0);
    }

    public static ArrayList<Integer> getAllPrimeFactors(int num) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int factor = 2;
        while (num > 1) {
            if (!primeNumberSet.contains(factor)) {
                factor++;
                continue;
            }
            if (num % factor == 0) {
                resultList.add(factor);
                num = num / factor;
            } else {
                factor++;
            }
        }
        return resultList;
    }

    public static void addPrimeNumber() {
        currentLargestPrimeNumber = nextPrimeNumber(currentLargestPrimeNumber);
        primeNumberSet.add(currentLargestPrimeNumber);
    }

    public static int nextPrimeNumber(int num) {
        int nextPrime = num;
        do {
            nextPrime += 2;
        } while (!isPrime(nextPrime));
        return nextPrime;
    }

    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        } else {
            boolean res = true;
            int i = 2;
            while (i < num / i) {
                if (num % i == 0) {
                    res = false;
                    break;
                } else {
                    i = i == 2 ? i + 1 : i + 2;
                }
            }
            return res;
        }
    }

}
