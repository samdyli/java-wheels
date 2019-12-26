package datastruct;

import org.checkerframework.checker.units.qual.C;

/**
 * @author gexiaochuan
 * @date 2019/12/26 20:08
 */
public interface Heap<E> {
  public boolean add(E element);
  public E top();
  public E poll();
}
