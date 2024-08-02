package 数组.一元数组;

/**
 * @author 10029
 * @date 2024/8/1
 */
public class 搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
            } else {
                return i;
            }
        }
        return nums.length;

    }

    public static void main(String[] args) {
        int nums [] = { 1,3,5,6};
        System.out.println(searchInsert(nums,5));
    }
}
