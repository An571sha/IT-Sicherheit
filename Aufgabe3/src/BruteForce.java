import java.security.NoSuchAlgorithmException;

/**
 * Author:    Animesh Sharma
 * Created:   24.03.2020
 *
 * This program generates a hash for a given Letter/Alphabet/Number combination
 * and matches with the hash of given password to find the password. We use this
 * brute force in two stages. First we list all the possible combination with
 * all the alphabets and then a combination of both. The password we are trying to
 * crack is - WERSDF43543
 * with hash - OKETIoL79R1IyhbJzr71orJ4oxFk4mgtNAivea4Yzz8iCamERU50e5vSGBmgrgCB6Jt+hdVdL7UbHP6rYfQKig==
 *
 **/

public class BruteForce {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetCaps = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    private static final String numbers = "12345678";
    public static final String hashToCompare = "OKETIoL79R1IyhbJzr71orJ4oxFk4mgtNAivea4Yzz8iCamERU50e5vSGBmgrgCB6Jt+hdVdL7UbHP6rYfQKig==";

    private static  String justAlphabets;
    private static  String alphabetsAndNums;
    private static StringBuilder alphabetStringBuilder = new StringBuilder();
    private static StringBuilder alphaNumStringBuilder = new StringBuilder();

    public static void main(String[] args) {
        justAlphabets = getAlphabetStringBuilder();
        alphabetsAndNums = getAlphaNumStringBuilder();
        Combination combination = new Combination(alphabetsAndNums);
        try {
            combination.combineAndCompare(0);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getAlphabetStringBuilder() {
        return alphabetStringBuilder.append(alphabet).append(alphabetCaps).toString();
    }

    public static String getAlphaNumStringBuilder() {
        return alphaNumStringBuilder.append(alphabet).append(alphabetCaps).append(numbers).toString();
    }

}
