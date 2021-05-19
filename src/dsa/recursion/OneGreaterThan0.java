package dsa.recursion;

/*
Print binary numbers having 1's more than 0's for any prefix
 */
public class OneGreaterThan0 {

    private static void printBinary(int n, int zero, int one, String output) {
        if(zero + one == n) {
            System.out.println(output);
            return;
        }
        String o1 = output + '1';
        printBinary(n, zero, one +1, o1);

        if(one > zero) {
            String o2 = output + '0';
            printBinary(n, zero + 1, one, o2);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        printBinary(n, 0, 0, "");
    }
}
