package com.hust.sonly;

public class Inverse {
	public static double[][] inverse(double[][] matrix) {
		
		
		
		
		
		return matrix;
	}
	
	/*
	 * �жϷ����Ƿ����
	 */
	public static boolean isReversible(double[][] matrix) {
		if(matrix.length != matrix[0].length) {
			System.out.println("�Ƿ������޷����");//���������󣬴����ӹ��������
			return false;
		} else if(matrix.length == 0) {
			System.out.println("������Ԫ��");//�վ���
			return false;
		}else if(determinant(matrix) == 0) {
			System.out.println("���󲻿���");//��������ʽ����0�����ǿ��淽��
			return false;
		}
		
		return true;
	}
	
	/*
	 * ��������ʽ��ֵ
	 */
	public static double determinant(double[][] matrix) {
		double value = 0;
		
		
		return value;
	}
}
