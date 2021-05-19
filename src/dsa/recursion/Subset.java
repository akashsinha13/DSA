package dsa.recursion;

/*
Print all subset of given string
 */
public class Subset {
    private static void subset(String input, String output) {
     if(input.length() == 0) {
         System.out.println(output);
         return;
     }
     String o1 = output;
     String o2 = output + input.charAt(0);
     input = input.substring(1);
     subset(input, o1);
     subset(input, o2);
    }

    public static void main(String[] args) {
        String input= "abc";
        subset(input, "");
    }
}
