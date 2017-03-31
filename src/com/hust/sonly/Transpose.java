package com.hust.sonly;

public class Transpose {
	/*
	 * Çó¾ØÕóµÄ×ªÖÃ¾ØÕó
	 */
	public static double[][] transpose(double[][] matrix) {
		double[][] tran = new double[matrix[0].length][matrix.length];
		
		for(int i = 0; i < tran.length; i++)
			for(int j = 0; j < tran[0].length; j++)
				tran[i][j] = matrix[j][i];
		
		return tran;
	}
}
