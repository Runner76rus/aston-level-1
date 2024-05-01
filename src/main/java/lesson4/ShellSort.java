package lesson4;

import java.util.List;

public final class ShellSort {

    private ShellSort() {
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int j = i;
                for (; j - gap >= 0 && arr[j] < arr[j - gap]; j = j - gap) {
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                }
            }
            gap = gap / 2;
        }
    }

    public static <T extends Comparable<T>> void sort(List<T> arr) {
        int len = arr.size();
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int j = i;
                for (; j - gap >= 0 && arr.get(j).compareTo(arr.get(j - gap)) < 0; j = j - gap) {
                    T temp = arr.get(j);
                    arr.set(j, arr.get(j - gap));
                    arr.set(j - gap, temp);
                }
            }
            gap = gap / 2;
        }
    }


}
