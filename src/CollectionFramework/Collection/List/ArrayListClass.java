package CollectionFramework.Collection.List;

/**
 * List 数据结构都是有序的
 */

import java.util.*;

/**
 * ArrayList 同 数组（Array）的区别：
 * ① 数组容量大小固定，不支持动态改变，效率高；
 *    数组地址空间连续分布
 * ② ArrayList 底层数组实现，可动态扩容，初始化可不需指定大小，一般用于无法确定数组大小时，但效率比数组低；
 *    查询效率高，支持增删改插，但效率低于 LinkedList；
 *    支持泛型；
 *    ArrayList 只能包含对象类型 (基本类型必须使用包装类)，
 *
 *
 *  ArrayList 可以用函数 toArray() 向数组转换，分为 无参 和 有参 两种：
 *    list.toArray() 返回的是 Object[]数组，可以在遍历时进行强制转换；
 *    list.toArray(T[] array) 将 List 元素复制到 array 数组中
 */
public class ArrayListClass {
    public static void main(String[] args) {
        /**
         * ArrayList 常用方法
         */
        // 构造函数，也可不指定初始大小
        List list1 = new ArrayList(3);
        // 支持泛型，必须使用包装类，所以有基本数据类型都要使用包装类
        List<Integer> list2 = new ArrayList<>();

        // add(Object o)：未指定索引，按顺序添加单个元素，未指定泛型时可以将各种类型数据加入List中
        list1.add(1);
        list1.add(1.2);
        list1.add("哈哈");
        // add(int i, Object o)：指定索引，在索引处插入单个元素，
        list1.add(1, "呵呵");
        System.out.println("add()：" + list1);  // [1, 呵呵, 1.2, 哈哈]

        // addAll(Collection c)：未指定索引，按顺序添加集合类中的所有元素
        list2.addAll(list1);
        // addAll(int i, Collection c)：指定索引，在索引处插入集合类中的所有元素
        list2.addAll(2, list1);
        System.out.println("addAll()：" + list2);  // [1, 呵呵, 1, 呵呵, 1.2, 哈哈, 1.2, 哈哈]

        // size()：获取List的大小
        System.out.println("size()：" + list2.size());  // 8


        // set(int i, Object o)：修改某位置的元素
        list1.set(3,"hhh");
        System.out.println("set(int i, Object o)：" + list1);  // [1, 呵呵, 1.2, hhh]


        // get(int i)：获取指定索引值中的元素
        System.out.println("get(int i)：" + list1.get(3)); // hhh


        // indexOf(Object o)：查找List中某元素的索引值，从前往后查找
        System.out.println("indexOf(Object o)：" + list1.indexOf("hhh")); // 3
        // lastIndexOf(Object o)：查找List中某元素最后一次出现的索引值，或者说是从后往前查找
        list1.add("hhh");
        System.out.println("lastIndexOf(Object o)：" + list1.lastIndexOf("hhh")); // 4


        // remove()：删除List里的单个元素：可以根据索引，也可以根据该元素值(仅删除查找到的第一个)
        list1.remove(1);
        System.out.println("remove(int i)：" + list1); // [1, 1.2, hhh, hhh]
        list1.remove("hhh");
        System.out.println("remove(Object o)：" + list1); // [1, 1.2, hhh]

        // removeAll(Collection c)：删除存在于List中指定集合的元素
        list2.removeAll(list1);
        System.out.println("removeAll(Collection c)：" + list2); // [呵呵, 呵呵, 哈哈, 哈哈]


        // contains()：



        /**
         * 数组转换为 List
         * ① 遍历数组元素分别插入 List 中
         * ② 使用 ArrayList 的含参构造函数，借助工具类 Arrays 的 asList() 方法
         * ③ List 的 addAll() 方法，借助工具类 Arrays 的 asList() 方法
         */
        Integer[] array1 = {1,2,3,4,5,6};
        // 遍历法
        List<Integer> list3 = new ArrayList<>();
        for (Integer i: array1) {
            list3.add(i);
        }

        // 通过含参构造函数，且必须使用Arrays.asList(array)
        List<Integer> list4 = new ArrayList<>( Arrays.asList(array1) );

        // addAll() 方法
        List<Integer> list5 = new ArrayList<>();
        list5.addAll(Arrays.asList(array1));


        /**
         * List 转换为数组
         */
        // toArray() 返回的是 Object 类型数组，可在遍历时强制转型
        Object[] array2 = list3.toArray();
        for (Object o: array2) {
            // 向下强制转型为其原本的类
            Integer a = (Integer) o;
        }

        // toArray(T[] array) 将 List 元素复制到已初始化的 array 数组中(需指定相应的大小)
        Integer[] array3 = new Integer[list3.size()];
        list3.toArray(array3);
        System.out.println(Arrays.toString(array3));
    }
}
