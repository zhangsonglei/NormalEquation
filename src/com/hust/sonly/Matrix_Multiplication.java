package com.hust.sonly;

public class Matrix_Multiplication {
	public static double[][] matrix_Multiplication(double[][] matrixA, double[][] matrixB) throws Exception {
		double[][] matrix = new double[matrixA.length][matrixB[0].length];
		
		if(matrixA[0].length != matrixB.length) {
			System.out.println("待乘矩阵不符合要求，A*B：A的列=B的行");
			return null;
		}
		
		for(int i = 0; i < matrixA.length; i++) {
			for(int j = 0; j < matrixB.length; j++) {
				for(int k = 0; k < matrixB[0].length; k++) {
					matrix[i][k] += matrixA[i][j] * matrixB[j][k];
				}
			}
		}
		return matrix;
	}
}
