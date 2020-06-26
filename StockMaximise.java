import java.util.ArrayList;
import java.util.List;

public class StockMaximise {

    public static long stockMax(List<Integer> prices) {
        long sum = 0;
        int end = prices.size() - 1;
        int front = end - 1;
        while (front >= 0) {
            if (prices.get(end) >= prices.get(front)) {
                sum += prices.get(end) - prices.get(front);
                front--;
            } else {
                end = front;
                front = end - 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.add(1);
        prices.add(3);
        prices.add(1);
        prices.add(2);
        System.out.println(stockMax(prices));
    }

}
