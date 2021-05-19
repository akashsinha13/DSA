package dsa.recursion;

/*
Permutation of cases of albhabets
 */
public class PermutationWithCase {

    private static void permutation(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        char temp = input.charAt(0);
        if(Character.isLetter(temp)) {
            String o1 = output + (temp+"").toUpperCase();
            String o2 = output + temp;
            input = input.substring(1);
            permutation(input, o1);
            permutation(input, o2);
        } else {
            String o3 = output + temp;
            input = input.substring(1);
            permutation(input, o3);
        }
    }

    public static void main(String[] args) {
        String input = "a2bc5";
        permutation(input, "");
    }
}
