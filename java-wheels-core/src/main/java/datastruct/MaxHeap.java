package datastruct;

import com.google.common.collect.Lists;

/**
 * @author gexiaochuan
 * @date 2019/12/27 17:21
 */
public class MaxHeap<E> extends AbstractHeap<E> {
  public MaxHeap(int capacity) {
    super(capacity);
  }

  @Override
  protected boolean isMaxHeap() {
    return false;
  }

  public static void main(String[] args) {
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(10);
    maxHeap.addAll(Lists.newArrayList(58, 32,73,20,31));
    System.out.println(maxHeap);
  }
}
