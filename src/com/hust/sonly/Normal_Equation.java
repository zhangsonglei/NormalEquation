package com.hust.sonly;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.hust.sonly.Inverse;
import com.hust.sonly.Matrix_Multiplication;
import com.hust.sonly.Transpose;

public class Normal_Equation {
	
	private static double[][] NE(double[][] matrixX, double[][] matrixY) throws Exception {
		/*
		 * para = (X^T * X)^(-1) * X^T * Y
		 * X^T代表X的转置，X^(-1)代表X的逆
		 */
		
		//matrixX*(matrixX的转置)
		double[][] matrix = Matrix_Multiplication.matrix_Multiplication(Transpose.transpose(matrixX), matrixX); 
		//matrix的逆矩阵*(matrixX的转置)
		matrix = Matrix_Multiplication.matrix_Multiplication(Inverse.inverse(matrix),Transpose.transpose(matrixX));
		//参数
		double[][] para = Matrix_Multiplication.matrix_Multiplication(matrix, matrixY);
				
		return para;
	}
	
	
	public static void main(String[] args) throws Exception {
//		double[][] X = {{2014,5,1,45},{1416,3,2,40},{1514,3,2,30},{852,2,1,36}};
//		double[][] Y = {{460},{232},{315},{178}};
		double[][] X = {{2,3,1},{4,2,3},{7,1,-1}};
		double[][] Y = {{4},{17},{1}};
		
		double[][] para = NE(X, Y);
		
		
		for(int i = 0; i < para.length; i++) {
			for(int j = 0; j < para[0].length; j++)
				System.out.print(para[i][j]+" ");
			System.out.println();
		}
	}
}
