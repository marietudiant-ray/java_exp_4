package matrixmultiply;

import java.util.Scanner;

public class MatrixMultiply {

	public int[][] a,b,c;
	public Scanner scanner;
	
	
	public int[][] input(int row,int column)
	{
		System.out.println("输入数组： 行数="+row+" 列数="+column);
		scanner=new Scanner(System.in);
		int[][] in=new int[row][column];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				in[i][j]=scanner.nextInt();
			}
		}
		return in;
	}
	
	public void  output(int[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public int[][] multi(int[][] a1,int[][] b1,int[][] c1)
	{
		c1=new int[a1.length][b1[0].length];
		if(a1[0].length==b1.length)
		{
			for(int i=0;i<a1.length;i++)
			{
				for(int p=0;p<b1[0].length;p++)
				{
					int sum=0;
				//	System.out.println(b1.length);
				    for(int j=0;j<b1.length;j++)
			       	{
				    	  //System.out.println(i+"  "+j+"    "+p);
					      sum+=a1[i][j]*b1[j][p];   
			       	}
				    c1[i][p]=sum;
				}
			}
		}
		return c1;
	}
	
	public MatrixMultiply()
	{
		System.out.println("let's begin");
	}
	public static void main(String[] args)
	{
		MatrixMultiply matrixmultiply=new MatrixMultiply();
		matrixmultiply.a=matrixmultiply.input(2, 3);
		matrixmultiply.b=matrixmultiply.input(3, 4);
		//matrixmultiply.output( matrixmultiply.a);
		//matrixmultiply.output( matrixmultiply.b);
		matrixmultiply.c=matrixmultiply.multi(matrixmultiply.a, matrixmultiply.b, matrixmultiply.c);
		matrixmultiply.output( matrixmultiply.c);
	}
	
}
