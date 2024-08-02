package 数组.二元数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 10029
 * @date 2024/8/1
 */
public class 合并区间 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        List<int[]> arrayList = new ArrayList<>();
        //先排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            //必须包含等于的情况
            if (intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            } else {
                arrayList.add(interval);
                interval = intervals[i];
            }
        }
        //当最后的区间是单独的 需要添加
        arrayList.add(interval);
        return arrayList.toArray(new int[arrayList.size()][2]);
    }

    public static void main(String[] args) {
        int intervals[] [] = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }
}
