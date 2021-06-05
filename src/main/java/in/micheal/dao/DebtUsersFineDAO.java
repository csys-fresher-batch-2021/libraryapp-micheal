package in.micheal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.micheal.constants.MessageConstants;
import in.micheal.exception.DbException;
import in.micheal.model.DebtUserDetail;
import in.micheal.util.ConnectionUtil;

public class DebtUsersFineDAO {
	private DebtUsersFineDAO() {

	}

	/**
	 * This method is used to get the fine amount the debt user
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static Integer getFineAmount(long userId) throws DbException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Integer fineAmount = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select fine_amount from lib_debtusers_fine_db where user_id=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);
			rs = pst.executeQuery();

			while (rs.next()) {
				fineAmount = rs.getInt("fine_amount");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return fineAmount;
	}

	/**
	 * This method is used to insert the fine amout to the data base
	 * 
	 * @param userId
	 * @param fineAmount
	 * @throws DbException
	 */
	public static void putFineAmount(long userId, int fineAmount) throws DbException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into lib_debtusers_fine_db (user_id , fine_amount) values (?,?)";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setInt(2, fineAmount);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to find the user in the database
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static Long findUserId(long userId) throws DbException {
		Long userid = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select user_id from lib_debtusers_fine_db where user_id=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);

			rs = pst.executeQuery();
			while (rs.next()) {
				userid = rs.getLong("user_id");

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);

		}

		return userid;
	}

	/**
	 * This method is used to update fine amount to the database
	 * 
	 * @param userId
	 * @param fineAmount
	 * @throws DbException
	 */
	public static void updateFineAmount(long userId, int fineAmount) throws DbException {

		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update lib_debtusers_fine_db set fine_amount=? where user_id = ?" + "";
			pst = con.prepareStatement(sql);

			pst.setInt(1, fineAmount);
			pst.setLong(2, userId);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}

	/**
	 * This method is used to get all details fromt the debt user fine data base
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<DebtUserDetail> getAll() throws DbException {

		List<DebtUserDetail> resultDebtUser = new ArrayList<>();
		Long userId = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from lib_debtusers_fine_db";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				DebtUserDetail user = new DebtUserDetail();
				userId = rs.getLong("user_id");
				int fineAmount = rs.getInt("fine_amount");
				user.setDebtUserId(userId);
				user.setFineAmount(fineAmount);
				resultDebtUser.add(user);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return resultDebtUser;
	}
}
