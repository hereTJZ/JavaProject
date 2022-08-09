package CollectionFramework.Map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.HashMap是线程不安全的，但效率高
 * 2.HashMap可以存储null键和null值
 * 3.HashMap是无序存储
 * 3.另外有 ConcurrentHashMap 是线程安全的，相比于 Hashtable 具备高并发性
 *
 * 一个键值对是一个 Map.Entry<K,Y> 对象
 */
public class HashMapClass {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("1",1);
        map.put("3",3);
        map.put("2",2);
        map.put("4",2);

        map.replace("3",4);  //不指定旧值
        map.replace("3", 3,4);  //指定正确旧值
        System.out.println(map.values());
        map.replace("3", 100,3);  //指定错误旧值，不做替换操作
        System.out.println(map.values());


        // 遍历map中值的方法
        for (Iterator iterator = map.values().iterator(); iterator.hasNext(); ) {
            int num = (int) iterator.next();
            System.out.println(num);
        }

        System.out.println();
        // 遍历map中键的方法
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            System.out.println(key);
        }

        System.out.println();
        // 遍历map中键值对的方法
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String,Integer> entry = (Map.Entry) iterator.next();
            System.out.println(entry);
        }
    }
}
