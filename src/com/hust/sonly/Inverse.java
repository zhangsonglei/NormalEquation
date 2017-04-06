package com.hust.sonly;

public class Inverse {
	/*
	 * �����������
	 */
	public static double[][] inverse(double[][] matrix) throws Exception {
		if(!isReversible(matrix)) {
			System.out.println("�޷���þ���������");
			return null;
		}
		
		double detMatrix = determinant(matrix); //��������ʽ��ֵ
		
        double inverseMatrix[][]=new double[matrix.length][matrix[0].length];//��������ת��
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            	inverseMatrix[i][j] = Math.pow(-1, i+j+2) * determinant(get_complement(matrix, i, j));
            }
        }
		
		inverseMatrix = Transpose.transpose(inverseMatrix); //ת�õõ��������
		inverseMatrix = Matrix_Multiplication.matrix_ScalarMultiplication(inverseMatrix, 1/detMatrix); //�����
		
		return inverseMatrix;
	}
	/*
	 * ���������ʽ
	 */
	public static double[][] get_complement(double[][] data, int i, int j) {
		 
        /* x��yΪ����data������������ */
        int x = data.length;
        int y = data[0].length;
 
        /* tempΪ����ʣ����� */
       double temp[][] = new double[x - 1][y - 1];
        for (int k = 0; k < x - 1; k++) {
            if (k < i) {
                for (int kk = 0; kk < y - 1; kk++) {
                    if (kk < j) {
                        temp[k][kk] = data[k][kk];
                    } else {
                        temp[k][kk] = data[k][kk + 1];
                    }
                }
 
            } else {
                for (int kk = 0; kk < y - 1; kk++) {
                    if (kk < j) {
                        temp[k][kk] = data[k + 1][kk];
                    } else {
                        temp[k][kk] = data[k + 1][kk + 1];
                    }
                }
            }
        }
        return temp;
    }
	
	
	/*
	 * �жϷ����Ƿ����
	 */
	public static boolean isReversible(double[][] matrix) {
		if(matrix.length != matrix[0].length) {
			System.out.println("�Ƿ���");//���������󣬴����ӹ��������
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
		
		if(matrix.length == matrix[0].length) {
			switch (matrix.length) {
			case 0: //������ʽ
				System.out.println("����ʽԪ��Ϊ��");
				value = 0; 
				break;
			case 1: //������ʽ
				value = matrix[0][0]; 
				break;
			case 2: //��������ʽֱ�ӽ�����ֵ
				value = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
				break;
			default: //����ʽ��������2ʱ������������˹չ��ʽ�������
				for(int i = 0; i < matrix[0].length; i++) {
					double factor = Math.pow(-1, i); //ϵ�����ţ�ÿ��ȡ��һ�еĴ�������ʽ
					double temp[][] = new double[matrix.length - 1][matrix[0].length - 1];//��������ʽ
					
					for(int j = 0; j < temp.length; j ++) {
						for(int k = 0; k < temp[0].length; k++) {
							if(k < i) {
								temp[j][k] = matrix[j + 1][k];
							}else {
								temp[j][k] = matrix[j + 1][k + 1];
							}
						}
					}
					value += matrix[0][i] * factor *determinant(temp);//�ݹ��������ʽ��ֵ
				}
				break;
			}
		}
		else {
			System.out.println("�Ƿ�������ʽ�޷����");
			return -1;
		}
		
		return value;
	}
}
