package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSort {

    public static void main(String[] args) {
        int[] arr = {9, 15, 7, -5, 5, 11, 3, 24, 1};
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 15, 7, -5, 5, 11, 3, 24, 1));
        System.out.println("Array\nBefore :");
        System.out.println(Arrays.toString(arr));
        ShellSort.sort(arr);
        System.out.println("After :");
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------------");
        System.out.println("List\nBefore :");
        System.out.println(list);
        ShellSort.sort(list);
        System.out.println("After :");
        System.out.println(list);
    }
}
