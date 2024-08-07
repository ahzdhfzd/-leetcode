package 数组.二元数组;

/**
 * @author 10029
 * @date 2024/8/3
 * 1 2 3 (0,0) (0,1) (1,0) (2,0) (1,1) (0,2) (1,2) (2,1) (2,2)
 * 4 5 6
 * 7 8 9 7(2,0) 5(1,1) 3(0,2)
 * 7 8 9
 */
public class 对角线遍历 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int 循环次数 = mat.length + mat[0].length - 1;
        int[] 结果 = new int[mat.length * mat[0].length];
        int r_index = 0;
        for (int i = 0; i < 循环次数; i++) {
            if (i % 2 == 0) {
                int min = Math.min(i, mat.length - 1);
                for (int i1 =min ; i - i1 <= mat[0].length-1 && i1>=0; i1--) {
                        结果[r_index++] = mat[i1][i - i1];

                }
            } else {
                int min = Math.min(i,mat[0].length-1);
                for (int i1 = min; i - i1 <= mat.length - 1 && i1>=0; i1--) {
                    结果[r_index++] = mat[i - i1][i1];

                }
            }

        }
        return 结果;

    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        findDiagonalOrder(mat);

    }
}
