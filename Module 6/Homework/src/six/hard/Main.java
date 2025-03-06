package six.hard;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    SafeList<String> list = new SafeList<>();
    list.add("apple");
    list.add("banana");
    list.add(null);
    list.add("apple");
    System.out.println(list.get(0));
    System.out.println(list.get(5));
  }
  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    return new ArrayList<>(new LinkedHashSet<>(list));
  }
}
class SafeList<T> implements List<T> {
  private final List<T> list = new ArrayList<>();
  @Override
  public boolean add(T element) {
    if (element == null || list.contains(element)) {
      return false;
    }
    return list.add(element);
  }
  @Override
  public T get(int index) {
    return (index >= 0 && index < list.size()) ? list.get(index) : null;
  }
  @Override
  public int size() {
    return list.size();
  }
  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }
  @Override
  public boolean contains(Object o) {
    return list.contains(o);
  }
  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
  @Override
  public Object[] toArray() {
    return list.toArray();
  }
  @Override
  public <T1> T1[] toArray(T1[] a) {
    return list.toArray(a);
  }
  @Override
  public boolean remove(Object o) {
    return list.remove(o);
  }
  @Override
  public boolean containsAll(Collection<?> c) {
    return list.containsAll(c);
  }
  @Override
  public boolean addAll(Collection<? extends T> c) {
    throw new UnsupportedOperationException();
  }
  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    throw new UnsupportedOperationException();
  }
  @Override
  public boolean removeAll(Collection<?> c) {
    return list.removeAll(c);
  }
  @Override
  public boolean retainAll(Collection<?> c) {
    return list.retainAll(c);
  }
  @Override
  public void clear() {
    list.clear();
  }
  @Override
  public T set(int index, T element) {
    throw new UnsupportedOperationException();
  }
  @Override
  public void add(int index, T element) {
    throw new UnsupportedOperationException();
  }
  @Override
  public T remove(int index) {
    return list.remove(index);
  }
  @Override
  public int indexOf(Object o) {
    return list.indexOf(o);
  }
  @Override
  public int lastIndexOf(Object o) {
    return list.lastIndexOf(o);
  }
  @Override
  public ListIterator<T> listIterator() {
    return list.listIterator();
  }
  @Override
  public ListIterator<T> listIterator(int index) {
    return list.listIterator(index);
  }
  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return list.subList(fromIndex, toIndex);
  }
}