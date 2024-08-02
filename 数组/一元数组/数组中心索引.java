package 数组.一元数组;

/**
 * @author 10029
 * @date 2024/8/1
 */
public class 数组中心索引 {
    public static int pivotIndex(int[] nums) {
        if (nums.length < 0){
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }


        int l_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sum == l_sum)
                return i;
            l_sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums [] = { 1, -1};
        System.out.println(pivotIndex(nums));
    }
}
