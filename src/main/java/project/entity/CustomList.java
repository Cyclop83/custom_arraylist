package project.entity;

/**
 * This interface provides methods for ordered collection.
 *
 * @param <E>
 */

public interface CustomList<E> {

  /**
   * This method returns an element of the CustomLIst, corresponding with the given index.
   *
   * @param index
   * @return
   */
  E get(int index);

  /**
   * This method adds an element to the end of the CustomList.
   *
   * @param element
   */
  void add(E element);

  /**
   * This method replaces the element with the given index to the provided element and returns the element that was
   * replaced.
   *
   * @param index
   * @param element
   * @return
   */
  E set(int index, E element);

  /**
   * This method removes the element with the given index from the CustomList, and returns this element.
   *
   * @param index
   * @return
   */
  E remove(int index);
}
