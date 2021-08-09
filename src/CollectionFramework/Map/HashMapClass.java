package CollectionFramework.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.HashMap是线程不安全的，但效率高
 * 2.HashMap可以存储null键和null值
 */
public class HashMapClass {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("1",1);
        System.out.println(map.get("2"));
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

    }
}
