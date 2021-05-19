package dsa.recursion;

public class JosephusProblem {
    private static  void josephusProblem(int n, int k, int index) {
        if(n==1) {
            System.out.println("Safe place is "+ index);
        }
        
    }

    public static void main(String[] args) {
        int n = 14;
        int k = 2;
        josephusProblem(n,k,0);
    }
}
