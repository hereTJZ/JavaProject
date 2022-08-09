package Leetcode;
import java.util.*;

// 矩阵中两点最短连线数，0为通路。
public class NumberOfShortestRoutes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] mit = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mit[i][j] = in.nextInt();
            }
        }
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        Queue<Integer> q =new LinkedList<>();

        // dfs
        dfs(mit,0,x1, y1, x2, y2);
        System.out.println(a);

    }
    static int a=100;

    static void dfs(int[][] mit, int step, int x1, int y1, int x2, int y2){
        int[][] mit1 = new int[mit.length][mit[0].length];
        //数组深拷贝
        for (int i = 0; i < mit.length; i++) {
            for (int j = 0; j < mit[0].length; j++) {
                mit1[i][j] = mit[i][j];
//                System.out.print(mit1[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();

        mit1[x1][y1] = 1;
        if (x1==x2 && y1==y2) {
            a=Math.min(step,a);
        }
        if(x1-1>0 && (mit1[x1-1][y1]==0 || (x1-1==x2 && y1==y2)))  // 上
            dfs(mit1, step+1, x1-1,y1,x2,y2);
        if(x1+1<mit.length && (mit1[x1+1][y1]==0 || (x1+1==x2 && y1==y2)))  // 下
            dfs(mit1, step+1, x1+1,y1,x2,y2);
        if(y1-1>0 && (mit1[x1][y1-1]==0 || (x1==x2 && y1-1==y2)))  // 左
            dfs(mit1, step+1, x1,y1-1,x2,y2);
        if(y1+1<mit1[0].length && (mit1[x1][y1+1]==0 || (x1==x2 && y1+1==y2)))  // 右
            dfs(mit1, step+1, x1,y1+1,x2,y2);
    }
}


/** input
3 5
1 0 2 0 3
0 2 0 1 1
0 3 0 0 0
0 2 1 1
*/