import java.util.HashMap;
import java.util.Scanner;

public class TimeConversion {

    private static HashMap<Integer, String> numbers;

    private static void initNumbers() {
        numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(21, "twenty one");
        numbers.put(22, "twenty two");
        numbers.put(23, "twenty three");
        numbers.put(24, "twenty four");
        numbers.put(25, "twenty five");
        numbers.put(26, "twenty six");
        numbers.put(27, "twenty seven");
        numbers.put(28, "twenty eight");
        numbers.put(29, "twenty nine");
    }

    private static String convert(String time) {
        return "";
    }

    private static String convert(int hour, int minute) {
        int targetHour = hour;
        if (targetHour == 0) {
            targetHour = 12;
        }
        boolean isPast = true;
        if (minute > 30) {
            targetHour = targetHour + 1;
            isPast = false;
            if (targetHour == 13) {
                targetHour = 1;
            }
            minute = 60 - minute;
        }
        if (minute == 0) {
            return numbers.get(targetHour) + " o'clock";
        } else if (minute == 30) {
            return "half past " + numbers.get(targetHour);
        } else {
            if (isPast) {
                if (minute == 1) {
                    return numbers.get(minute) + " minute past " + numbers.get(targetHour);
                } else if (minute == 15) {
                    return "quarter past " + numbers.get(targetHour);
                } else {
                    return numbers.get(minute) + " minutes past " + numbers.get(targetHour);
                }
            } else {
                if (minute == 1) {
                    return numbers.get(minute) + " minute to " + numbers.get(targetHour);
                } else if (minute == 15) {
                    return "quarter to " + numbers.get(targetHour);
                } else {
                    return numbers.get(minute) + " minutes to " + numbers.get(targetHour);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initNumbers();
        while (true) {
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(convert(h, m));
        }
    }

}
