package Leetcode;

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = {1,2,5,8};
        int target = 7;
        BinarySearch b = new BinarySearch();
        System.out.println(b.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;  //也可以是left + ((right - left ) >> 1)
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }

        }
        return left;
    }
}
