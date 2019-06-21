import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by kiana on 11/19/17.
 */
public class Matrix implements Runnable{

    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] matrix3;
    private Bound bound;

    public Matrix(int[][] matrix1, int[][] matrix2, int[][] matrix3, Bound bound) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrix3 = matrix3;
        this.bound = bound;
    }

    @Override
    public void run() {
        for (int i = bound.getStart(); i < bound.getEnd(); i++){
            for (int j = 0 ; j < matrix2[0].length ; j++){
                matrix3[i][j] = 0;
                for (int z = 0 ; z < matrix1[0].length ; z++){
                    matrix3[i][j] += matrix1[i][z]*matrix2[z][j];
                }
            }
        }
    }
}
