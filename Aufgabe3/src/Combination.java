import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Combination {
    private final String inputString;
    private int counter;
    private StringBuilder output = new StringBuilder();
    private static MessageDigest messageDigest;

    public Combination(final String str, int counter) {
        inputString = str;
        this.counter = counter;
        System.out.println("The input string  is  : " + inputString);
    }

    public void combineAndCompare(int start) throws NoSuchAlgorithmException {
        messageDigest = Encrypt.getMessageDigest();
        for (int i = start; i < inputString.length(); ++i ) {
            output.append (inputString.charAt(i));

            //System.out.println(output);
            String encrypted = Encrypt.encryptString(messageDigest, output.toString());
            if(!encrypted.equals(BruteForce.hashToCompare)){
                counter++;
               // System.out.println(counter);
            }
            if (i < inputString.length())
                combineAndCompare( i + 1);
            output.setLength( output.length() - 1 );
        }


    }
}
