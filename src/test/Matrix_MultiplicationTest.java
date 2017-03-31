package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hust.sonly.Matrix_Multiplication;

public class Matrix_MultiplicationTest {

	@Test
	public void test() throws Exception {
		double[][] A = {{1,2,3}};
		double[][] B = {{1,1},{0,0},{1,2}};
		double[][] matrix = new double[A.length][B[0].length];
		
		matrix = Matrix_Multiplication.matrix_Multiplication(A, B);
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}

	}

}
