package DataStructure.SparseArray;

import com.sun.deploy.net.MessageHeader;

import java.io.*;

//稀疏数组实现棋盘
public class SparseArray {
    private static MessageHeader ArrayUtils;

    public static void main(String[] args) throws IOException {
        //创建一个原始二维数组 10 * 10
        //0 表示没有棋子，1 表示白色棋子，2 表示黑色棋子
        int[][] chess = new int[6][6];
        chess[1][3] = 1;
        chess[3][1] = 2;
        chess[5][4] = 1;

        //输出原始数组
        for (int[] row : chess) {
            for (int data : row) {
                System.out.print("  " + data + "  ");
            }
            System.out.println('\n');
        }
        System.out.println("======================================");


        //首先统计有效值（棋子）个数
        int sum = 0;
        for (int[] ints : chess) {
            for (int anInt : ints) {
                if (anInt != 0)
                    sum++;
            }
        }

        //将原始数组转换成稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chess.length;  //行数
        sparseArray[0][1] = chess[0].length;  //列数
        sparseArray[0][2] = sum;
        for (int i = 0, k = 1; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] != 0) {
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = chess[i][j];
                    k++;
                }
            }
        }

        //输出稀疏数组
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.print("  " + data + "  ");
            }
            System.out.println('\n');
        }
        System.out.println("===============================================");
        //将稀疏数组保存至磁盘
        File file = new File("src/DataStructure/sparseArray/map.data");
        OutputStream out = new FileOutputStream(file, false);  //true表示向文件末尾追加内容，默认为false覆盖
        OutputStreamWriter outw = new OutputStreamWriter(out, "utf-8");
        StringBuilder str = new StringBuilder();
        for (int[] ints:sparseArray) {
            for (int a : ints) {
                str.append(a);
            }
            str.append('\n');
        }
        outw.write(str.toString());
        outw.close();


        //恢复原始数组
        int[][] preliminary_chess = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            preliminary_chess[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出原始数组
        for (int[] row : preliminary_chess) {
            for (int data : row) {
                System.out.print("  " + data + "  ");
            }
            System.out.println('\n');
        }
    }
}
