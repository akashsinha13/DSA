package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Sort a list using recursion
Added this class just to check the understanding of recursion
 */
public class ArraySort {

    public static void sort(List<Integer> list) {
        int size = list.size();
        if(size <= 1) {
            return;
        }
        int lastElement = list.get(size - 1);
        list.remove(size-1);
        sort(list);
        insert(list, lastElement);
    }

    public static void insert(List<Integer> list, int key) {
        int size = list.size();
        if(size == 0 || list.get(size-1) < key) {
            list.add(size, key);
            return;
        }
        int lastElement = list.get(size - 1);
        list.remove(size-1);
        insert(list, key);
        list.add(lastElement);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(4);

        sort(list);
        System.out.println(list.toString());
    }
}
