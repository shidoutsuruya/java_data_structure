import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Sort {
    private static Comparable aux[];

    /*
     * pop sort
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    /*
     * shell sort
     */
    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /*
     * merge sort
     */
    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) // copy array
            aux[k] = a[k];
        for (int k = low; k <= high; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > high)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void mergeSort(Comparable[] a) {
        aux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /* bottom-up merge sort */
    public static void bottomUpMergeSort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz * 2) {
            for (int low = 0; low < N - sz; low += (sz * 2)) {
                merge(a, low, low + sz - 1, Math.min(low + sz * 2 - 1, N - 1));
            }
        }
    }

    /* quick sort */
    public static void quickSort(Comparable[] a) {
        List list = Arrays.asList(a);
        Collections.sort(list);
        Object[] array = list.toArray();
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] a, int low, int high) {
        if (high <= low)
            return;
        int j = partition(a, low, high);
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v))
                if (i == high)
                    break;
            while (less(v, a[--j]))
                if (j == low)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
    /*quick sort 3-way */
    private static void Quick3waySort(Comparable[] a,int low, int high)
    {
        if(high<=low) return;
        int lt=low,i=low+1,gt=high;
        Comparable v=a[low];
        while(i<=gt)
        {
            int cmp=a[i].compareTo(v);
            if(cmp<0) exch(a,lt++,i++);
            else if(cmp>0) exch(a,i,gt--);
            else i++;
        }
        Quick3waySort(a,low,lt-1);
        Quick3waySort(a,gt+1,high);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i += 1) {
            System.out.println(a[i]);
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i += 1) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = { "a", "dfdf", "agdd", "JOIN", "ADSDA", "cvcx" };
        quickSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
