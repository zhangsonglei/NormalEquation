package com.hust.sonly;

public class Inverse {
	/*
	 * 求矩阵的逆矩阵
	 */
	public static double[][] inverse(double[][] matrix) throws Exception {
		if(!isReversible(matrix)) {
			System.out.println("无法求该矩阵的逆矩阵");
			return null;
		}
		
		double detMatrix = determinant(matrix); //矩阵行列式的值
		
        double inverseMatrix[][]=new double[matrix.length][matrix[0].length];//伴随矩阵的转置
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            	inverseMatrix[i][j] = Math.pow(-1, i+j+2) * determinant(get_complement(matrix, i, j));
            }
        }
		
		inverseMatrix = Transpose.transpose(inverseMatrix); //转置得到伴随矩阵
		inverseMatrix = Matrix_Multiplication.matrix_ScalarMultiplication(inverseMatrix, 1/detMatrix); //逆矩阵
		
		return inverseMatrix;
	}
	/*
	 * 求矩阵余子式
	 */
	public static double[][] get_complement(double[][] data, int i, int j) {
		 
        /* x和y为矩阵data的行数和列数 */
        int x = data.length;
        int y = data[0].length;
 
        /* temp为所求剩余矩阵 */
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
	 * 判断方阵是否可逆
	 */
	public static boolean isReversible(double[][] matrix) {
		if(matrix.length != matrix[0].length) {
			System.out.println("非方阵");//简单求解逆矩阵，待增加广义逆的求法
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
		
		if(matrix.length == matrix[0].length) {
			switch (matrix.length) {
			case 0: //空行列式
				System.out.println("行列式元素为空");
				value = 0; 
				break;
			case 1: //空行列式
				value = matrix[0][0]; 
				break;
			case 2: //二阶行列式直接交叉求值
				value = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
				break;
			default: //行列式阶数大于2时，利用拉普拉斯展开式进行求解
				for(int i = 0; i < matrix[0].length; i++) {
					double factor = Math.pow(-1, i); //系数符号，每次取第一行的代数余子式
					double temp[][] = new double[matrix.length - 1][matrix[0].length - 1];//代数余子式
					
					for(int j = 0; j < temp.length; j ++) {
						for(int k = 0; k < temp[0].length; k++) {
							if(k < i) {
								temp[j][k] = matrix[j + 1][k];
							}else {
								temp[j][k] = matrix[j + 1][k + 1];
							}
						}
					}
					value += matrix[0][i] * factor *determinant(temp);//递归计算行列式的值
				}
				break;
			}
		}
		else {
			System.out.println("非方阵行列式无法求解");
			return -1;
		}
		
		return value;
	}
}
