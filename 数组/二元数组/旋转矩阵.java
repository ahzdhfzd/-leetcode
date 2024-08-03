package 数组.二元数组;

/**
 * @author 10029
 * @date 2024/8/2
 *
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *
 *  1 4 7   2(0,1) 4(1,0) 3(0,2) 7 (2,0)
 *  2 5 8
 *  3 6 9
 *
 *   7 4 1 1(0,0) 7(0,2) length = 3 即 length-i-1
 *   8 5 2
 *   9 6 3
 *
 *  [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 *
 *   5 2 13 15
 *
 *
 */
public class 旋转矩阵 {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            //i1要从i开始，防止将替换完的 重新替换回来
            for (int i1 = i; i1 < matrix[i].length; i1++) {
                int 中间值 = matrix[i][i1];
                matrix[i][i1] = matrix[i1][i];
                matrix[i1][i] = 中间值;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            //只替换前半部分，否则重置
            for (int i1 = 0; i1 < matrix[i].length/2; i1++) {
                int 中间值 = matrix[i][i1];
                matrix[i][i1] = matrix[i][matrix[i].length-1-i1];
                matrix[i][matrix[i].length-1-i1] = 中间值;
            }
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
    }
}
