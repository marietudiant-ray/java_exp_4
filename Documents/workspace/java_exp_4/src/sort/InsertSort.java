package sort;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sort.Connect_Sql;

public class InsertSort {
	
	int[] score;
	int[] id;
	public int num[];
	public int length;
	public ResultSet result;
	public Connect_Sql connect;
	public String name;
	
	public InsertSort(String name )
	{
		this.name=name;
	}
	
	public void direct(int n[])
	{
	   for(int i=1;i<n.length;i++)
	   {
		   for(int j=i-1;j>=0&&n[j+1]>n[j];j--)
		   {
			   int tmp=n[j+1];
			   n[j+1]=n[j];
			   n[j]=tmp;
			  // System.out.println(i+"   "+j+"  "+n[j+1]+"  "+n[j]);
		   }
	   }
	}
	
	public void connect() throws SQLException
	{
		  connect =new Connect_Sql();
			String sql="select * from sort_table";
		    result=connect.query(sql);
			
		get_length:	result.last();
			        length=result.getRow();
			        result.first();
	}
	
	public void disconnect()
	{
		try {
			connect.statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sort() throws SQLException
	{
		id=new int[length];
		score=new int[length];
		int in=0;
			do{
				//System.out.println(result.getInt(2));
				id[in]=result.getInt(1);
	            score[in]=result.getInt(2);
	      //  System.out.println(score[in]+"     "+in);
	        in++;
			}while(result.next()&&in<length);
		
		direct(score);
		String str="";
		for(int i=0;i<length;i++)
		{
			str+=score[i]+"\t";
		}
		JOptionPane.showMessageDialog(null, str,"结果排序",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void print() throws SQLException
	{
		String str="";
		for(int i=0;i<length;i++)
			{
			str+="id: "+id[i]+" score: "+score[i]+"\n";
			}
		System.out.println(str);
		
	}
	
	
	public static void main(String[] args) throws SQLException
	{
	   String name="排序";
	   InsertSort insertsort=new InsertSort(name);
	   insertsort.connect();
	 /*  String sql="insert into sort_table (score) values(87),(45),(67),(34),(53),(42),(12),(72),(49),(10)";
	   insertsort.connect.execute(sql);*/
	  // insertsort.connect.printData(result)
	   insertsort.sort();
	   insertsort.print();
	   insertsort.disconnect();
	   System.exit(0);
	}

}
                       