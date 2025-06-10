package algorithms;

public class TrackCharacterFrequencies {

    public static void main(String[] args) {
        String s = "phungminhdat"; // just lowercase alphabet characters

        int[] frequencies = trackCharacterFrequencies(s);
        char ch = 'n'; // expected output: 2
        System.out.println(frequencies[ch - 'a']);
    }

    private static int[] trackCharacterFrequencies(String s) {
        int[] arr = new int[26]; // a-z
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}
