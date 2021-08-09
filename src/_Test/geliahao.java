package _Test;

import java.util.Scanner;

public class geliahao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int miniResult = 10000000;
        int sum = 0;

        for (int i = 1; i < 5000; i++) {
            int a = geliahao.toSum(i);
            sum=i;
            boolean find =false;
            int p = 1;
            int[] num = new int[n];
            num[0]=i;int k = 1;
            for (int j = i + 1; j < 5000; j++) {
                int b = geliahao.toSum(j);
                if(a==b){
                    sum+=j;
                    p++;
                    num[k]=j;
                    k++;
                    if(p==n){
                        find=true;
                        break;
                    }
                }
            }
            if (find) {
                if(miniResult>sum)
                    miniResult=sum;
            }
        }

        System.out.println(miniResult);
    }

    public static int toSum(int i){
        char[] c = String.valueOf(i).toCharArray();
        int result = 0;
        for (char num:c) {
            result+= (int) (num) - 48;
        }
        return result;
    }
}
