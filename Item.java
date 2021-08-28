import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Item<E extends Comparable>  {

    public Collection<E> merge(Collection<E> c1, Collection<E> c2) {
        // edge cases
        if (c1 == null || c1.size() == 0) {
            return c2;
        }

        if (c2 == null || c2.size() == 0) {
            return c1;
        }

        Collection<E> mergedRes = new ArrayList<>();
        Iterator<E> iterator1 = c1.iterator();
        Iterator<E> iterator2 = c2.iterator();
        E prev1 = null;
        E prev2 = null;

        // iterate both collections and merge while iterating
        while (iterator1.hasNext() && iterator2.hasNext()) {
            E cur1 = prev1 == null || prev1.compareTo(prev2) < 0 ? iterator1.next() : prev1;
            E cur2 = prev2 == null || prev2.compareTo(prev1) <= 0 ? iterator2.next() : prev2;
            if(cur1.compareTo(cur2) <= 0) {
                mergedRes.add(cur1);
            } else {
                mergedRes.add(cur2);
            }

            prev1 = cur1;
            prev2 = cur2;
        }

        if (!iterator1.hasNext()) {
            mergedRes.add(prev2);
            while (iterator2.hasNext()) {
                mergedRes.add(iterator2.next());
            }
        } else if (!iterator2.hasNext()) {
            mergedRes.add(prev1);
            while (iterator1.hasNext()) {
                mergedRes.add(iterator1.next());
            }
        }

        return mergedRes;
    }

    public static void  main(String[] args) {
        // several tests cases
        Item<Integer> item1 = new Item<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,1,3,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1,2,2,8,9));
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1,1,3,5));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(1,2,2,8,9));
        Queue<Integer> queue1 = new ArrayDeque<>(Arrays.asList(1,1,3,5));
        Queue<Integer> queue2 = new ArrayDeque<>(Arrays.asList(2,2,2,8,9));

        List<String> l3 = new LinkedList<>();
        List<String> l4 = new LinkedList<>(Arrays.asList("a", "bc", "dd"));

        System.out.println(item1.merge(set1, set2));
        System.out.println(item1.merge(list1, list2));
        System.out.println(item1.merge(queue1, queue2));

        Item<String> item2 = new Item<>();
        System.out.println(item2.merge(l3, l4));
    }
}