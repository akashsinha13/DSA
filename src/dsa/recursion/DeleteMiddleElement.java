package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Delete middle element from list
 */
public class DeleteMiddleElement {
    public static void deleteMiddle(List<Integer> list, int middle) {
        int size = list.size();
        if(size == 0) {
            return;
        }
        if(middle==0) {
            list.remove(size-1);
            return;
        }
        int last = list.get(size-1);
        list.remove(size-1);
        deleteMiddle(list, middle-1);
        list.add(last);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int mid = (int)Math.floor(list.size()/2);
        deleteMiddle(list, mid);
        System.out.println(list.toString());
    }
}
