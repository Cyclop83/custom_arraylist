package project.entity;

/**
 * This class provides implementation for CustomList.
 *
 * @param <E>
 */
public class CustomArrayList<E> implements CustomList<E> {

  private int capacity;

  private Object[] elementData;

  private final int capacityIncreaseRatio;

  private boolean elementDataIsFull;

  private int size;

  public CustomArrayList() {
    this(10);
  }

  public CustomArrayList(int capacity) {
    this.capacity = capacity;
    this.elementData = new Object[capacity];
    this.capacityIncreaseRatio = 2;
    this.elementDataIsFull = false;
  }

  /**
   * This is implementation of the corresponding CustomList method.
   *
   * @param index
   * @return
   */
  @Override
  public E get(int index) {
    validateIndex(index);
    return (E) elementData[index];
  }

  /**
   * This is implementation of the corresponding CustomList method.
   *
   * @param element
   */
  @Override
  public void add(E element) {
    if (elementDataIsFull) {
      elementData = increaseArrayCapacity(elementData);
    }
    for (int i = 0; i < elementData.length; i++) {
      if (elementData[i] == null) {
        elementData[i] = element;
        size++;
        if (i == elementData.length - 1) {
          elementDataIsFull = true;
        }
        break;
      }
    }
  }

  /**
   * This is implementation of the corresponding CustomList method.
   *
   * @param index
   * @param element
   * @return
   */
  @Override
  public E set(int index, E element) {
    validateIndex(index);
    E previousElement = (E) elementData[index];
    elementData[index] = element;
    return previousElement;
  }

  /**
   * This is implementation of the corresponding CustomList method.
   *
   * @param index
   * @return
   */
  @Override
  public E remove(int index) {
    validateIndex(index);
    E removedValue = (E) elementData[index];
    Object[] result = new Object[elementData.length - 1];
    System.arraycopy(elementData, 0, result, 0, index);
    System.arraycopy(elementData, index + 1, result, index, result.length - index);
    elementData = result;
    size--;
    return removedValue;
  }

  private void validateIndex(int index) {
    if (index > size - 1) {
      throw new IndexOutOfBoundsException();
    }
  }

  private Object[] increaseArrayCapacity(Object[] income) {
    Object[] result = new Object[income.length * capacityIncreaseRatio];
    System.arraycopy(income, 0, result, 0, income.length);
    return result;
  }

  /**
   * This method returns the number of elements in the CustomArrayList
   *
   * @return
   */
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder resultBuilder = new StringBuilder("[");
    for (int i = 0; i < elementData.length; i++) {
      if (elementData[i] != null) {
        resultBuilder.append(elementData[i] + " ");
      }
    }
    return resultBuilder.toString().trim().concat("]");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CustomArrayList)) {
      return false;
    }
    CustomArrayList<E> that = (CustomArrayList<E>) o;
    for (int i = 0; i < elementData.length; i++) {
      if (this.elementData[i] != null && !this.elementData[i].equals(that.elementData[i])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    if (size() == 0) {
      return 1000;
    }
    int listHashcode = 0;
    for (int i = 0; i < size(); i++) {
      listHashcode = get(i).hashCode();
    }
    return listHashcode / size();
  }
}
