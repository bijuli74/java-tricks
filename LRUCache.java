
import java.util.LinkedHashMap;
import java.util.Map;

// Implemeting LRUCache via inheriting LinkedHashMap collection
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

  private final int capacity;

  public LRUCache(int capacity) {

    // size, load-factor, removeEldestEntry
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  };

  public static void main(String[] args) {
    LRUCache<Integer, String> cache = new LRUCache<Integer, String>(5);

    for (int i = 1; i <= 5; i++) {
      cache.put(i, "DUMMY");
    }
    System.out.println("Initial Cache: ");
    System.out.println(cache.keySet());

    cache.put(6, "DUMMY");
    System.out.println("6 inserted so 1 evicted");
    System.out.println(cache.keySet());

    System.out.println("Accessing key: 2");
    cache.get(2);

    System.out.println("Insert 99");
    cache.put(99, "DUMMY");
    System.out.println(cache.keySet());
  }

}
