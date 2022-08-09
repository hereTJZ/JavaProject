package Leetcode;
import java.util.*;

//顺时针由外到内螺旋式读取数值
public class TanChiShe {

    static List<Integer> beans(int[][] matrix) {
        int _matrix_rows = matrix.length;
        int _matrix_cols = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();

        int direction = 0;  //遍历方向：0右 1下 2左 3上
        int left=0, right = _matrix_cols-1, up = 0, bottom = _matrix_rows-1;  //当前行进方向的边界
        for (int count = 0; count < _matrix_cols * _matrix_rows; ) {
            switch (direction){
                //往右行进
                case 0:
                    for (int i = left; i <= right ; i++) {
                        res.add(matrix[up][i]);
                        count++;
                    }
                    up++;
                    direction = 1;
                    break;

                //往下行进
                case 1:
                    for (int i = up; i <= bottom ; i++) {
                        res.add(matrix[i][right]);
                        count++;
                    }
                    right--;
                    direction = 2;
                    break;

                //往左行进
                case 2:
                    for (int i = right; i >= left ; i--) {
                        res.add(matrix[bottom][i]);
                        count++;
                    }
                    bottom--;
                    direction = 3;
                    break;

                //往上行进
                case 3:
                    for (int i = bottom; i >= up; i--) {
                        res.add(matrix[i][left]);
                        count++;
                    }
                    left++;
                    direction = 0;
                    break;
            }
        }

        return res;

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Integer> res;

        int _matrix_rows = in.nextInt();
        int _matrix_cols = in.nextInt();

        int[][] _matrix = new int[_matrix_rows][_matrix_cols];
        for(int _matrix_i=0; _matrix_i<_matrix_rows; _matrix_i++) {
            for(int _matrix_j=0; _matrix_j<_matrix_cols; _matrix_j++) {
                _matrix[_matrix_i][_matrix_j] = in.nextInt();
            }
        }

        //消除回车符
        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = beans(_matrix);
        for(int res_i=0; res_i < res.size(); res_i++) {
            System.out.println(String.valueOf(res.get(res_i)));
        }

    }

}
