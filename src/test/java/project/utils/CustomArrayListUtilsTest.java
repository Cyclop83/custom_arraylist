package project.utils;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.entity.CustomArrayList;

public class CustomArrayListUtilsTest {

  @Test
  void shouldReturnTrueForQuickSort() {
    //Given
    CustomArrayList<Integer> testList = populateTestCustomArrayList();

    //When
    CustomArrayList<Integer> expectedList = populateExpectedCustomArrayList();
    CustomArrayListUtils.quickSort(testList);

    //Then
    Assertions.assertEquals(testList, expectedList);
  }

  @Test
  void shouldReturnFalseForQuickSort() {
    //Given
    CustomArrayList<Integer> testList = populateTestCustomArrayList();
    testList.set(3, 99);

    //When
    CustomArrayList<Integer> expectedList = populateExpectedCustomArrayList();
    CustomArrayListUtils.quickSort(testList);

    //Then
    Assertions.assertNotEquals(testList, expectedList);
  }

  @Test
  void shouldReturnTrueForQuickSortWithComparator() {
    //Given
    CustomArrayList<Integer> testList = populateTestCustomArrayList();

    //When
    CustomArrayList<Integer> expectedList = populateExpectedForComparatorCustomArrayList();
    CustomArrayListUtils.quickSort(testList, new SortIntegerByReverseToNaturalOrder());

    //Then
    Assertions.assertEquals(testList, expectedList);
  }

  @Test
  void shouldReturnFalseForQuickSortWithComparator() {
    //Given
    CustomArrayList<Integer> testList = populateTestCustomArrayList();
    testList.set(3, 99);

    //When
    CustomArrayList<Integer> expectedList = populateExpectedForComparatorCustomArrayList();
    CustomArrayListUtils.quickSort(testList, new SortIntegerByReverseToNaturalOrder());

    //Then
    Assertions.assertNotEquals(testList, expectedList);
  }

  private CustomArrayList<Integer> populateTestCustomArrayList() {
    CustomArrayList<Integer> list = new CustomArrayList<>(10);
    list.add(-5);
    list.add(2);
    list.add(54);
    list.add(0);
    list.add(22);
    list.add(-17);
    list.add(88);
    list.add(0);
    list.add(-160);
    list.add(31);
    return list;
  }

  private CustomArrayList<Integer> populateExpectedCustomArrayList() {
    CustomArrayList<Integer> list = new CustomArrayList<>(10);
    list.add(-160);
    list.add(-17);
    list.add(-5);
    list.add(0);
    list.add(0);
    list.add(2);
    list.add(22);
    list.add(31);
    list.add(54);
    list.add(88);
    return list;
  }

  private CustomArrayList<Integer> populateExpectedForComparatorCustomArrayList() {
    CustomArrayList<Integer> list = new CustomArrayList<>(10);
    list.add(88);
    list.add(54);
    list.add(31);
    list.add(22);
    list.add(2);
    list.add(0);
    list.add(0);
    list.add(-5);
    list.add(-17);
    list.add(-160);
    return list;
  }
}

class SortIntegerByReverseToNaturalOrder implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
    return -o1.compareTo(o2);
  }
}
