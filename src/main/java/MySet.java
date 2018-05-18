import java.util.Collections;
import java.util.HashMap;

public class MySet<T> implements LimitedSet<T>{

    private HashMap<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        if (map.size() == 10) {
            remove(Collections.min(map.entrySet(), HashMap.Entry.comparingByValue()).getKey());
        }
        map.put(o, 0);
    }

    @Override
    public boolean remove(T o) {
        Object name = o;
        if (map.containsKey(o)) {
            map.remove(o);
            System.out.println("Element " + o + " was removed!");
        } else {
            System.out.println("Element does not exists!");
        }
        return false;
    }

    @Override
    public boolean contains(T o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o)+1);
            System.out.println(o + " is existing!");
        } else {
            System.out.println("Element does not exists!");
        }
        return false;
    }

    public void show() {
        for (HashMap.Entry entry: map.entrySet())
            System.out.println(entry.getKey());
    }
}
