package 数组.二元数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10029
 * @date 2024/8/3
 */
public class 零矩阵 {
    public static void setZeroes(int[][] matrix) {
        Map<Integer,String> xmap = new HashMap<>();
        Map<Integer,String> ymap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                if (matrix[i][y] == 0){
                    xmap.put(i, "");
                    ymap.put(y, "");
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                if (matrix[i][y] == 0) continue;
                if (xmap.containsKey(i) || ymap.containsKey(y)){
                    matrix[i][y] = 0;
                }
            }
        }

    }
}
