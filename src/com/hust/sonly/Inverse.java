package com.hust.sonly;

public class Inverse {
	public static double[][] inverse(double[][] matrix) {
		
		
		
		
		
		return matrix;
	}
	
	/*
	 * 判断方阵是否可逆
	 */
	public static boolean isReversible(double[][] matrix) {
		if(matrix.length != matrix[0].length) {
			System.out.println("非方阵，暂无法求解");//简单求解逆矩阵，待增加广义逆的求法
			return false;
		} else if(matrix.length == 0) {
			System.out.println("方阵无元素");//空矩阵
			return false;
		}else if(determinant(matrix) == 0) {
			System.out.println("方阵不可逆");//方阵行列式等于0，不是可逆方阵
			return false;
		}
		
		return true;
	}
	
	/*
	 * 求方阵行列式的值
	 */
	public static double determinant(double[][] matrix) {
		double value = 0;
		
		
		return value;
	}
}
