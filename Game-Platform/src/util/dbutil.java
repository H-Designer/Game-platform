package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class dbutil {
	public  static  Connection getConnection() {
		Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象

		    try
		    {
		        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动
		        System.out.println("Oracle驱动加载成功");
		        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// url地址
		        String user = "c##scott";// 用户名
		        String password = "tiger";// 密码
		        con = DriverManager.getConnection(url, user, password);// 链接数据库
		        System.out.println("数据库连接成功");
		    }
		    catch (Exception e)
		    {
		        e.printStackTrace();
		    }
			return con;
	}
	public static void close(ResultSet rs,Statement state,Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(state!=null){
			try{
				state.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
	//关闭数据库
	public static void close(Connection connection ) {
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
