package datastruct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author gexiaochuan
 * @date 2019/12/26 20:13
 */
public abstract class AbstractHeap<E> implements Heap<E> {

  private Comparator<E> comparator;
  private List<E> data;
  private int size;
  private int capacity = -1;
  private boolean isMaxHeap;

  public AbstractHeap(int capacity) {
    data = new ArrayList<E>();
    this.capacity = capacity;
  }

  protected abstract boolean isMaxHeap();

  private boolean isFull() {
    return capacity != -1 && size == capacity;
  }

  private int leftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int rightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int parentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public boolean add(E element) {
    if (isFull()) {
      return false;
    } else {
      if (null == comparator) {
        comparator = new Comparator<E>() {
          public int compare(E o1, E o2) {
            final Comparable<E> comparable = (Comparable<E>) o1;
            return comparable.compareTo(o2);
          }
        };
      }

      size++;
      int lastIndex = size - 1;
      int parentIndex;
      E parentElement;
      while ((parentIndex = parentIndex(lastIndex)) > 0 && null != (parentElement = data
          .get(parentIndex)) && unsorted(comparator, parentElement,
          element, isMaxHeap())
      ) {
        swap(lastIndex, parentIndex);
        lastIndex = parentIndex;
      }
    }
    return true;
  }

  private void swap(int lastIndex, int parentIndex) {
    E parentElement = data.get(parentIndex);
    data.set(parentIndex, data.get(lastIndex));
    data.set(lastIndex, parentElement);
  }

  private boolean unsorted(Comparator<E> comparable, E parentElement, E element,
      boolean isMaxHeap) {
    return (isMaxHeap && comparable.compare(parentElement, element) < 0) ||
        (!isMaxHeap() && comparable.compare(parentElement, element) > 0);
  }
}
