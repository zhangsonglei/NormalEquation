package test;

import org.junit.Test;

import com.hust.sonly.Transpose;

public class TransposeTest {

	@Test
	public void test() {
		double[][] A = {{1,2,3},{4,5,6}};
		double[][] B = Transpose.transpose(A);
		
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[0].length; j++)
				System.out.print(B[i][j]+" ");
			System.out.println();
		}
	}

}
