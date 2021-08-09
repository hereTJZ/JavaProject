package Leetcode;

//二分法实现有序二维数组中的元素查找
public class BinarySearchMatrix {
    public static void main(String[] args) {
        //二维数组看做是多个纵向的一维数组组成的数组
        int[][] nums = {{1, 3, 5, 6}, {8, 9, 10, 12}, {15, 6, 18, 20}};
        BinarySearchMatrix a = new BinarySearchMatrix();
        System.out.println(a.searchMatrix(nums, 12));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        //行数
        int row = matrix.length;
        //列数
        int colum = matrix[0].length;
        int left = 0;
        //行数乘列数 - 1，右指针
        int right = row * colum - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);//位运算提高性能

            //将一维坐标变为二维坐标
            int rownum = mid / colum;
            int colnum = mid % colum;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

}
