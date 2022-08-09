package CollectionFramework.Map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 有序结构
 * TreeMap判断键是否相同是依赖于键的 compareTo() 方法，而不是键的hashCode、equals方法
 */
public class TreeMapClass {
    public static void main(String[] args) {
        Map<Integer,String> treemap = new TreeMap<>();
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
