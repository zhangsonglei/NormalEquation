package com.hust.sonly;

public class Normal_Equation {
	public static void main(String[] args) throws Exception {
//		double[][] A = {{1,2,3,4},{5,6,7,8},{0,1,2,3}};
//		
//		System.out.println(A.length+" "+A[0].length);
		
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
