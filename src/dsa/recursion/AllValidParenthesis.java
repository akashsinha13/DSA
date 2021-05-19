package dsa.recursion;

/*
Generate all the valid parenthesis of given number
 */
public class AllValidParenthesis {
    private static void generateValidParenthesis(int open, int close, String output) {
        if(open == 0 && close == 0) {
            System.out.println(output);
            return;
        }
        if(open != 0) {
            String output1 = output +  '{';
            generateValidParenthesis(open-1, close, output1);
        }
        if(open < close) {
            String output2 = output + '}';
            generateValidParenthesis(open, close-1, output2);
        }
    }

    public static void main(String[] args) {
        int numberOfParenthesis = 3;
        generateValidParenthesis(numberOfParenthesis, numberOfParenthesis, "");
    }
}
