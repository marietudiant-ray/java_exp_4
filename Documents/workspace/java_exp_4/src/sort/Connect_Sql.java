package sort;

import javax.swing.JOptionPane;

import sort.Values;
import java.sql.*;


public class Connect_Sql {
	
	public Statement statement;
	
	public  Connect_Sql() throws SQLException 
	{
		try {
			Class.forName(Values.DRIVER_MYSQL);
			System.out.println("Driver Load Success");
			String user="root",pwd="mari901214";
			//user=JOptionPane.showInputDialog(null, "请输入用户");
			//pwd=JOptionPane.showInputDialog(null, "请输入密码");
			Connection connection=DriverManager.getConnection(Values.URL, user, pwd);
			statement=connection.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql)
	{
		ResultSet result=null;
		try {
			result=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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

}
