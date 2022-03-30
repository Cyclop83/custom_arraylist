package project.utils;

import java.util.Comparator;
import project.entity.CustomArrayList;

/**
 * This class provides some utility methods for CustomArrayList
 */
public class CustomArrayListUtils {

  /**
   * Sorts the specified list into ascending order, according to the natural ordering of its elements. All elements in
   * the list must implement the Comparable interface.
   *
   * @param list
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void quickSort(CustomArrayList<T> list) {
    quickSort(list, 0, list.size() - 1);
  }

  /**
   * Sorts the specified list according to the order induced by the specified comparator. All elements in the list must
   * be mutually comparable using the specified comparator.
   *
   * @param list
   * @param comparator
   * @param <T>
   */
  public static <T> void quickSort(CustomArrayList<T> list, Comparator<? super T> comparator) {
    quickSort(list, 0, list.size() - 1, comparator);
  }

  private static <T extends Comparable<? super T>> void quickSort(CustomArrayList<T> list, int low, int high) {
    if (list == null || list.size() == 0) {
      return;
    }

    if (low >= high) {
      return;
    }

    int middle = low + (high - low) / 2;
    T pivot = list.get(middle);

    int i = low, j = high;
    while (i <= j) {
      while (list.get(i).compareTo(pivot) < 0) {
        i++;
      }
      while (list.get(j).compareTo(pivot) > 0) {
        j--;
      }
      if (i <= j) {
        swapForComparable(list, i, j);
        i++;
        j--;
      }
    }
    if (low < j) {
      quickSort(list, low, j);
    }
    if (high > i) {
      quickSort(list, i, high);
    }
  }

  private static <T> void quickSort(CustomArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
    if (list == null || list.size() == 0) {
      return;
    }

    if (low >= high) {
      return;
    }

    int middle = low + (high - low) / 2;
    T pivot = list.get(middle);

    int i = low, j = high;
    while (i <= j) {
      while (comparator.compare(list.get(i), pivot) < 0) {
        i++;
      }
      while (comparator.compare(list.get(j), pivot) > 0) {
        j--;
      }
      if (i <= j) {
        swapForComparator(list, i, j);
        i++;
        j--;
      }
    }
    if (low < j) {
      quickSort(list, low, j, comparator);
    }
    if (high > i) {
      quickSort(list, i, high, comparator);
    }
  }

  private static <T extends Comparable<? super T>> void swapForComparable(CustomArrayList<T> list, int x, int y) {
    T temp = list.get(x);
    list.set(x, list.get(y));
    list.set(y, temp);
  }

  private static <T> void swapForComparator(CustomArrayList<T> list, int x, int y) {
    T temp = list.get(x);
    list.set(x, list.get(y));
    list.set(y, temp);
  }
}
