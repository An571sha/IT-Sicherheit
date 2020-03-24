public class BruteForce {

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] alphabetCaps = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    private void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private void printArray(String[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {

            System.out.print(input[i]);
        }
    }

    private void getAllPossiblePermutation() {


    }


}
