package _Test;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringNoDuplicate {
    public static void main(String[] args) {
        String s = "aaab!bb";
        int result = 0;
        int subLength = 0;
        int l = s.length();

        Set<Character> set = new HashSet<Character>();
        for(int i=0,j=0; i<l; i++){
            while(j<s.length() && set.add(s.charAt(j))){
                subLength++;
                j++;
            }
            result = Math.max(result, subLength);

            //第一个指针直接移到重复字符第一次出现位置的下一位,并删除集合中前面出现的字符
            if(j<l && i <= s.indexOf(s.charAt(j), i)) {
                set.remove(s.charAt(i));
                subLength--;
            }
        }
        System.out.println(result);
    }
}
