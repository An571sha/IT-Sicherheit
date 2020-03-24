import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encrypt {
    private static final String STANDARD = "SHA-512";
    private static final String outputFilePath = "res/result.txt";
    private static final String[] encryptThis = {"Pass123456"};
    private static final String[] encryptedList = new String[encryptThis.length];
    private static MessageDigest messageDigest;

    public static void main(String[] args) {
        try {
            int counter = 0;
            messageDigest = getMessageDigest();
            for (String encryptThi : encryptThis) {

                String encrypted = encryptString(messageDigest, encryptThi);
                encryptedList[counter] = encrypted;
                counter++;
            }

            writeToFile(outputFilePath, encryptedList);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, String[] encryptedHash){

        File outputFile = new File(filePath);
        try {

            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            FileWriter fileWriter =  new FileWriter(outputFile);
            for (String encyptedString : encryptedHash) {
                System.out.println(encyptedString);
                fileWriter.write(encyptedString);
                fileWriter.write(System.lineSeparator());

            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(STANDARD);
    }

    public static String encryptString(MessageDigest messageDigest, String inputString){
        if (inputString != null && !inputString.isEmpty()) {

            byte[] stringsInBytes = inputString.getBytes(StandardCharsets.UTF_8);
            byte[] endResult = messageDigest.digest(stringsInBytes);
            return Base64.getEncoder().encodeToString(endResult);
        }
        return null;
    }
}