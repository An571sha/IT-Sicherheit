import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.concurrent.*;

/**
 * Author:    Animesh Sharma
 * Created:   24.03.2020
 *
 * This program generates a hash for a given Letter/Alphabet/Number combination
 * and matches with the hash of given password to find the password. We use this
 * brute force in two stages. First we list all the possible combination with
 * all the alphabets and then a combination of both. The password we are trying to
 * crack is - Pass123456
 * with hash - AEgbRoNMuHjaFq7L44ER9W+aR/9a6iS2Vwabtjmko11wHTEKykryL1/R8CuTG3hvF7e04yePUF1XwQU9fdux+w==
 *
 **/

public class BruteForce {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphabetCaps = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    private static final String numbers = "12345678";
    public static final String hashToCompare = "AEgbRoNMuHjaFq7L44ER9W+aR/9a6iS2Vwabtjmko11wHTEKykryL1/R8CuTG3hvF7e04yePUF1XwQU9fdux+w==";

    private static String justAlphabets;
    private static String alphabetsAndNums;
    private static long startTime;
    private static long endTime;
    private static int counter = 0;
    private static Future<Integer> future;
    private static Thread t1 ;
    private static ExecutorService executor ;
    private static StringBuilder alphabetStringBuilder = new StringBuilder();
    private static StringBuilder alphaNumStringBuilder = new StringBuilder();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {
        justAlphabets = getAlphabetStringBuilder();
        alphabetsAndNums = getAlphaNumStringBuilder();
        Combination combination = new Combination(alphabetsAndNums,counter);
        System.out.println("Press s: to start and b: to stop");
        try {

            while(true) {
                switch (in.readLine()) {
                    case "s": {
                        t1 = new Thread(() -> {
                            try {
                                System.out.println("Comparing given hash with all possible permutation");
                                combination.combineAndCompare(0);
                                counter = 2;

                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            }

                        });
                        t1.start();
                        startTime = System.nanoTime();
/*
                        executor = Executors.newSingleThreadExecutor();
                        Callable<Integer> callable = new Callable<Integer>() {
                            @Override
                            public Integer call() {
                                try {
                                    System.out.println("Comparing given hash with all possible permutation");
                                    combination.combineAndCompare(0);
                                    counter = 2;

                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                }
                                return counter;
                            }
                        };
                        future = executor.submit(callable);
                        startTime = System.nanoTime();

*/
                    }
                    break;
                    case "b": {
                        t1.interrupt();
                      //  executor.shutdown();
                        endTime = System.nanoTime();
                        long totalTime = endTime - startTime;
                        System.out.println("Total time: " + TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS) + " seconds");
                        System.out.println("counter: " + future.get());
                        System.exit(0);
                    }

                    break;
                }
            }

        } catch (IOException | ExecutionException | InterruptedException e) {
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
