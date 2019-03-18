package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import msg.information;
import util.dbutil;
public class gamedao {
	//登陆
	public information login(String gameid)
	{
		PreparedStatement preparedStatement = null;
		Connection connection = dbutil.getConnection();
		ResultSet resultSet=null;
		information infor=null;
		String sql="select * from GAME_USER where gameid=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gameid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				infor=new information();
				infor.setGameid(resultSet.getString("gameid"));
				infor.setPassword(resultSet.getString("password"));
				infor.setGamename(resultSet.getString("gamename"));
				infor.setPhone(resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(resultSet);
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
		return infor;
	}
	//注册
	
		public void register(information infor) {
			PreparedStatement preparedStatement = null;
			Connection connection = dbutil.getConnection();
			String sql = "insert into GAME_USER(gameid,gamename,password,phone) values(?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,infor.getGameid());
				preparedStatement.setString(2,infor.getGamename());
				preparedStatement.setString(3,infor.getPassword());
				preparedStatement.setString(4,infor.getPhone());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
		}
		//单个人查询
		public information select(String gameid)
		{
			PreparedStatement preparedStatement = null;
			Connection connection = dbutil.getConnection();
			ResultSet resultSet=null;
			information infor=null;
			String sql="select * from GAME_USER where gameid=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, gameid);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					infor=new information();
					infor.setPassword(resultSet.getString("password"));
					infor.setGamename(resultSet.getString("gamename"));
					infor.setGameid(resultSet.getString("gameid"));
					infor.setPhone(resultSet.getString("phone"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbutil.close(resultSet);
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
			return infor;
		}
		//管理员全部对象查询
		public List<information> selectall(){
			List<information> infor = new ArrayList<information>();
			String sql="select * from GAME_USER ";
			PreparedStatement preparedStatement = null;
			Connection connection = dbutil.getConnection();
			ResultSet resultSet=null;
			information information =null;
			try{
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					information = new information();
					information.setId(resultSet.getInt("id"));
					information.setGameid(resultSet.getString("gameid"));
					information.setGamename(resultSet.getString("gamename"));
					information.setPassword(resultSet.getString("password"));
					information.setPhone(resultSet.getString("phone"));
					infor.add(information);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				dbutil.close(resultSet);
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
			return infor;
		}
		//单一游戏对象查询
				public List<information> selectgame(String  gamename){
					List<information> infor = new ArrayList<information>();
					String sql="select * from GAME_USER where gamename=?";
					PreparedStatement preparedStatement = null;
					Connection connection = dbutil.getConnection();
					ResultSet resultSet=null;
					information information =null;
					try{
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, gamename);
						resultSet = preparedStatement.executeQuery();
						while(resultSet.next()){
							information = new information();
							information.setId(resultSet.getInt("id"));
							information.setGameid(resultSet.getString("gameid"));
							information.setGamename(resultSet.getString("gamename"));
							information.setPhone(resultSet.getString("phone"));
							infor.add(information);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						dbutil.close(resultSet);
						dbutil.close(preparedStatement);
						dbutil.close(connection);
					}
					return infor;
				}
		
		//个人修改个人信息
		public void update(information infor) {
			PreparedStatement preparedStatement = null;
			Connection connection = dbutil.getConnection();
			String sql = "update GAME_USER set gamename=?,gameid=?,password=?,phone=?  where gameid=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,infor.getGamename());
				preparedStatement.setString(2,infor.getGameid());
				preparedStatement.setString(3,infor.getPassword());
				preparedStatement.setString(4,infor.getPhone());
				preparedStatement.setString(5,infor.getSessionid());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
		}
		//管理员修改信息
		public void update1(information infor) {
			PreparedStatement preparedStatement = null;
			Connection connection = dbutil.getConnection();
			String sql = "update GAME_USER set gamename=?,gameid=?,password=?,phone=?  where id=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,infor.getGamename());
				preparedStatement.setString(2,infor.getGameid());
				preparedStatement.setString(3,infor.getPassword());
				preparedStatement.setString(4,infor.getPhone());
				preparedStatement.setInt(5,infor.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
		}
		
		//删除
		public void delete(int id) {
			Connection connection = dbutil.getConnection();
			String sql = "delete from GAME_USER where id = ?";
			PreparedStatement preparedStatement = null;
			
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbutil.close(preparedStatement);
				dbutil.close(connection);
			}
			
		}
		
}
