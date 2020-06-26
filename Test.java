interface TestT {
    void method();
}

class Base {
    public void method() {
        System.out.println("Inside Base");
    }
}

public class Test extends Base implements TestT {
    public static void main(String[] args) {
        // 1. practice of Interface, what is the output
        (new Test()).method();

        // 2. practice of numbers, what is the output
        int mask = 0x000f;
        int value = 0x2222;
        System.out.println(mask & value);

        // 3. practice of numbers, what is the output of the program
        try {
            float f = 3.0f;
            int i = (int) f;
            byte b = (byte) f;
            double d = (double) f;
            System.out.println(i + b + d);
        } catch (NumberFormatException e) {
            System.out.println("Bad Number");
        }

        // 4. practice of comments, which comment is invalid;
        // A. /* here is a comment ****** */
        // B. /* this is also a comment /* More comments */ */
        // C. /* this is also a comment // More comments */
        // D. // /* this is a // // comment */
    }
}
