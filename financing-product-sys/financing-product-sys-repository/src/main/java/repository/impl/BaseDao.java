package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class BaseDao {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "peter", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object execute(String sql, Object... params) {
		try(Connection conn = getConnection();) {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//如果ps.execute执行的是查询，则返回true。否则返回false
			if(ps.execute()) {
				//下面两行用于获得一个行集crs，行集是ResultSet的子集
				//行集在数据库连接关闭之后，里面的数据依然是可以访问的。结果集则不行
				RowSetFactory rsf = RowSetProvider.newFactory(); 
				CachedRowSet crs = rsf.createCachedRowSet();	
				crs.populate(ps.getResultSet());//从ps中取出结果集，填充进行集
				return crs;
			} else {
				return ps.getUpdateCount(); //执行增删改等操作，返回受影响行数
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
