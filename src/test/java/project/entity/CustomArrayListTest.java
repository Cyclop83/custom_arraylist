package project.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {

  @Test
  void shouldAddElementToTheCustomList() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When
    testList.add(99);

    //Then
    Assertions.assertEquals(testList.get(6), 99);
  }

  @Test
  void shouldReplaceElementInTheCustomList() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When
    testList.set(4, 99);

    //Then
    Assertions.assertEquals(testList.get(4), 99);
  }

  @Test
  void shouldThrowArrayIndexOutOfBoundsExceptionForSet() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When - Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.set(6, 99));
  }

  @Test
  void shouldReturnRequestedElement() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When - Then
    Assertions.assertEquals(testList.get(5), -17);
  }

  @Test
  void shouldThrowArrayIndexOutOfBoundsExceptionForGet() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When - Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.get(6));
  }

  @Test
  void shouldRemoveElementFromCustomList() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When - Then
    Assertions.assertEquals(testList.remove(0), -5);
    Assertions.assertEquals(testList.get(0), 2);
  }

  @Test
  void shouldThrowArrayIndexOutOfBoundsExceptionForRemove() {
    //Given
    CustomList<Integer> testList = populateCustomArrayList();

    //When - Then
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(6));
  }

  @Test
  void shouldReturnProperCustomListSize() {
    //Given
    CustomArrayList<Integer> testList = populateCustomArrayList();
    Assertions.assertEquals(testList.size(), 6);

    //When - Then
    testList.remove(5);
    Assertions.assertEquals(testList.size(), 5);
    testList.add(77);
    Assertions.assertEquals(testList.size(), 6);
    testList.set(3, -35);
    Assertions.assertEquals(testList.size(), 6);
  }

  @Test
  void shouldReturnTrueWhenEquals() {
    //Given
    CustomArrayList<Integer> testList = new CustomArrayList<>(100);
    testList.add(-5);
    testList.add(2);
    testList.add(54);
    testList.add(0);
    testList.add(22);
    testList.add(-17);

    //When - Then
    Assertions.assertEquals(populateCustomArrayList(), testList);
  }

  @Test
  void shouldReturnFalseWhenEquals() {
    //Given
    CustomArrayList<Integer> testList = new CustomArrayList<>(100);
    testList.add(-5);
    testList.add(2);
    testList.add(54);
    testList.add(0);
    testList.add(22);

    //When - Then
    Assertions.assertNotEquals(populateCustomArrayList(), testList);
  }

  @Test
  void shouldReturnTrueForHashcode() {
    //Given
    CustomArrayList<Integer> testList = populateCustomArrayList();

    //When
    CustomArrayList<Integer> list = new CustomArrayList<>(10);
    list.add(-5);
    list.add(2);
    list.add(54);
    list.add(0);
    list.add(22);
    list.add(-17);

    //Then
    Assertions.assertEquals(testList.hashCode(), list.hashCode());
  }

  @Test
  void shouldReturnFalseForHashcode() {
    //Given
    CustomArrayList<Integer> testList = populateCustomArrayList();

    //When
    CustomArrayList<Integer> list = new CustomArrayList<>(10);
    list.add(-5);
    list.add(2);
    list.add(54);
    list.add(0);
    list.add(22);

    //Then
    Assertions.assertNotEquals(testList.hashCode(), list.hashCode());
  }

  private CustomArrayList<Integer> populateCustomArrayList() {
    CustomArrayList<Integer> list = new CustomArrayList<>();
    list.add(-5);
    list.add(2);
    list.add(54);
    list.add(0);
    list.add(22);
    list.add(-17);
    return list;
  }
}
