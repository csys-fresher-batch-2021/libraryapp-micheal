package in.micheal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.micheal.exception.DbException;
import in.micheal.model.UserDetails;
import in.micheal.util.ConnectionUtil;

public class UserDetailsDAO {
	private UserDetailsDAO() {
		// default constructor
	}

	/**
	 * This method is used to add users
	 * 
	 * @param userObj
	 * @throws DbException
	 */
	public static void addUser(UserDetails userObj) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into lib_user_details_db (id , password,phone_no,name) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, userObj.getUserId());
			pst.setString(2, userObj.getPassword());
			pst.setLong(3, userObj.getPhoneNo());
			pst.setString(4, userObj.getUserName());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("UNABLE TO ADD USER");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method finds the given user or returns null
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static Long findUser(long userId) throws DbException {
		Long userid = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		try {

			con = ConnectionUtil.getConnection();
			String sql = "select id from lib_user_details_db where id=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);

			rs = pst.executeQuery();
			while (rs.next()) {
				userid = rs.getLong("id");

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("UNABLE TO FIND USER");
		} finally {

			ConnectionUtil.close(rs, pst, con);
		}
		return userid;
	}

	/**
	 * This method is used to get user id of the given user id and password
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws DbException
	 */
	public static Long getUserIdAndPassword(long userId, String password) throws DbException {
		Long resultUserId = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;             
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select id from lib_user_details_db where id=? AND password=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setString(2, password);

			rs = pst.executeQuery();
			while (rs.next()) {
				resultUserId = rs.getLong("id");

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("UNABLE TO FETCH DATAS");
		} finally {
			ConnectionUtil.close(rs, pst, con);

		}
		return resultUserId;

	}

	/**
	 * This method is used to add admin
	 * 
	 * @param userObj
	 * @throws DbException
	 */

	public static void addAdmin(UserDetails userObj) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into lib_user_details_db (id , password,phone_no,name) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, userObj.getUserId());
			pst.setString(2, userObj.getAdminPassword());
			pst.setLong(3, userObj.getPhoneNo());
			pst.setString(4, userObj.getUserName());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("UNABLE TO ADD ADMIN ");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete all records from the Database ,CAUTION:Highly
	 * sensible code
	 * 
	 * @throws DbException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void deleteAllRecords() throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Query
			String sql = "delete from lib_user_details_db";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("UNABLE TO DELETE RECORDS");
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}
}
