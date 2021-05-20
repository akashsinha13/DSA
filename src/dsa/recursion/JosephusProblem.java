package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    private static  void josephusProblem(int n, int k, int index, List<Integer> table) {
        if(n==1) {
            System.out.println("Safe place is "+ table.get(0));
            return;
        }
        index = (index+k)%table.size();
        table.remove(index);
        josephusProblem(n-1, k, index, table);
    }

    public static void main(String[] args) {
        int n = 14;
        int k = 2;
        List<Integer> table = new ArrayList<>();
        for(int i=0; i<n; i++)
            table.add(i+1);
        josephusProblem(n,k-1,0, table);
    }
}
