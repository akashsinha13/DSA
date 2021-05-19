package dsa.recursion;

/*
Add space after each char
 */
public class PermutationWithSpace {

    private static void permutation(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String o1 = output + input.charAt(0);
        String o2 = output + "_" + input.charAt(0);
        input= input.substring(1);
        permutation(input, o1);
        permutation(input, o2);
    }

    public static void main(String[] args) {
        String input = "abc";
        String output = ""+ input.charAt(0);
        permutation(input.substring(1), output);

    }
}
