import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Combination {
    private final String inputString;
    private StringBuilder output = new StringBuilder();
    private static MessageDigest messageDigest;

    public Combination(final String str) {
        inputString = str;
        System.out.println("The input string  is  : " + inputString);
    }

    public void combineAndCompare(int start) throws NoSuchAlgorithmException {
        messageDigest = Encrypt.getMessageDigest();
        for (int i = start; i < inputString.length(); ++i ) {
            output.append (inputString.charAt(i));
            System.out.println(output);
            byte[] stringsInBytes = output.toString().getBytes(StandardCharsets.UTF_8);
            byte[] endResult = messageDigest.digest(stringsInBytes);
            String encrypted = Base64.getEncoder().encodeToString(endResult);
            if(!encrypted.equals(BruteForce.hashToCompare)){
                System.out.println("not equals");
            }
            if (i < inputString.length())
                combineAndCompare( i + 1);
            output.setLength( output.length() - 1 );
        }
    }
}
