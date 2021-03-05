package datastruct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author gexiaochuan
 * @date 2019/12/26 20:13
 */
public abstract class AbstractHeap<E> implements Heap<E> {

  private Comparator<E> comparator;
  private E[] data;
  private int size;
  private int capacity = -1;
  private boolean isMaxHeap;

  public AbstractHeap(int capacity) {
    data = (E[]) new Object[capacity];
    this.capacity = capacity;
    isMaxHeap = isMaxHeap();
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
    return childIndex <= 0 ? -1 : (childIndex - 1) / 2;
  }

  public boolean add(E element) {
    if (isFull()) {
      E topElement = top();
      int compareVal = comparator.compare(element, topElement);
      if (compareVal == 0) {
        return true;
      }

      boolean maxHeapAndLessThan = isMaxHeap && compareVal > 0;
      boolean minHeapAndGreatThan = !isMaxHeap && compareVal < 0;
      if (maxHeapAndLessThan || minHeapAndGreatThan) {
        int currentIndex = 0;
        int leftChild;
        int rightChild;
        while ((leftChild = leftChildIndex(currentIndex)) > size) {
        }
      }
    } else {
      if (null == comparator) {
        comparator = new Comparator<E>() {
          public int compare(E o1, E o2) {
            final Comparable<E> comparable = (Comparable<E>) o1;
            return comparable.compareTo(o2);
          }
        };
      }
      int lastIndex = size - 1;
      int parentIndex;
      E parentElement;

      data[size++] = element;
      while ((parentIndex = parentIndex(lastIndex)) >= 0
          && null != (parentElement = data[parentIndex]) && unsorted(comparator, parentElement,
          element, isMaxHeap())
      ) {
        swap(lastIndex, parentIndex);
        lastIndex = parentIndex;
      }
    }
    return true;
  }

  public void addAll(List<E> elements) {
    for (E e : elements) {
      add(e);
    }
  }

  private void swap(int lastIndex, int parentIndex) {
    E parentElement = data[parentIndex];
    data[parentIndex] = data[lastIndex];
    data[lastIndex] = parentElement;
  }

  public E top() {
    return data.length <= 0 ? null : data[0];
  }

  public E poll() {
    return null;
  }

  private boolean unsorted(Comparator<E> comparable, E parentElement, E element,
      boolean isMaxHeap) {
    return (isMaxHeap && comparable.compare(parentElement, element) < 0) ||
        (!isMaxHeap && comparable.compare(parentElement, element) > 0);
  }

  @Override
  public String toString() {
    return "size=" + size + " capacity = " + capacity + " data = " + Arrays.toString(data);
  }
}
