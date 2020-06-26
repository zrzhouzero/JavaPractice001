import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {

    // methods include: "MD5", "SHA-1", "SHA-256"
    public static String getHashing(String input, String method) {
        try {
            MessageDigest md = MessageDigest.getInstance(method);

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashText = new StringBuilder(no.toString(16));
            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "HelloWorld";
        String method = "MD5";
        System.out.println(getHashing(input, method));
    }

    /*
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.reset();
        m.update(input.nextLine().getBytes());
        for (byte i : m.digest()) {
            System.out.print(String.format("%02x", i));
        }
        System.out.println();
    }
    */
}
