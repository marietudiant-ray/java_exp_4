package test_connect_sql;

import test_connect_sql.Values;
import java.sql.*;

import javax.swing.JOptionPane;

public class JDBC_Test {
	
	private Statement statement;
	
	public JDBC_Test() throws SQLException 
	{
		try {
			Class.forName(Values.DRIVER_MYSQL);
			System.out.println("Driver Load Success.");
			
			Connection connection=DriverManager.getConnection(Values.URL, Values.USER, Values.Pwd);
			statement=connection.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet query(String sql)
	{
		ResultSet result=null;
		
		try
		{
			result=statement.executeQuery(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public void printResultSet(ResultSet result)
	{
		String str="";
		try {
			while(result.next())
			{
				str+="id :"+result.getString(1)+"  score :"+result.getLong(2)+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, str, "students' scores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void execute(String sql)
	{
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		String sql="select * from sort_table";
		try {
			JDBC_Test t=new JDBC_Test();
			ResultSet result=t.query(sql);
			t.printResultSet(result);
			t.statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
