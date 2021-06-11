package in.micheal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.micheal.constants.MessageConstants;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.util.ConnectionUtil;

public class DebtUserDetailsDAO {
	private DebtUserDetailsDAO() {
		// default constructor
	}

	/**
	 * This method adds debt users to debt users
	 * 
	 * @param obj
	 * @throws DbException
	 */
	public static void addDebtUsers(DebtUserDetail obj) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into debtuser_db ( user_id ,taken_book,taken_quantity,taken_date) values (?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setDouble(1, obj.getDebtUserId());
			pst.setString(2, obj.getTakenBook());
			pst.setInt(3, obj.getTekenBookQuantity());

			java.sql.Date sqlDate = new java.sql.Date(obj.getTakenDate().getTime());

			pst.setDate(4, sqlDate);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method finds the debt user id who took the given book name and has id of
	 * given id
	 * 
	 * @param userID
	 * @param bookName
	 * @return
	 * @throws DbException
	 */
	public static Long findDebtUser(Long userId, String bookName) throws DbException {
		Long userIdentify = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select user_id from debtuser_db where user_id=? AND taken_book=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, userId);
			pst.setString(2, bookName);

			rs = pst.executeQuery();
			while (rs.next()) {
				userIdentify = rs.getLong(MessageConstants.USER_ID);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return userIdentify;
	}

	/**
	 * This method returns book quantity of the given debt user id and the given
	 * book name
	 * 
	 * @param userId
	 * @param bookName
	 * @return
	 * @throws DbException
	 */

	public static int getTakenBookQuantity(long userId, String bookName) throws DbException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		int takenQuantity = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select taken_quantity from debtuser_db where user_id=? AND taken_book=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setString(2, bookName);
			rs = pst.executeQuery();

			while (rs.next()) {
				takenQuantity = rs.getInt(MessageConstants.QUANTITY);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return takenQuantity;
	}

	/**
	 * This method updates the book quantity of the given book name and given user
	 * id
	 * 
	 * @param bookName
	 * @param quantity
	 * @param userId
	 * @throws DbException
	 */

	public static void updateBookQuantity(String bookName, int quantity, long userId) throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update debtuser_db set taken_quantity = ? where taken_book = ? AND user_id=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, quantity);
			pst.setString(2, bookName);
			pst.setLong(3, userId);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}

	/**
	 * This method deletes the debt user id of the given user id and given book name
	 * from the database
	 * 
	 * @param userId
	 * @param bookName
	 * @throws DbException
	 */
	public static void deleteDebtUser(long userId, String bookName) throws DbException {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "delete from debtuser_db where user_id=? AND taken_book=? ";
			pst = con.prepareStatement(sql);

			pst.setLong(1, userId);
			pst.setString(2, bookName);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);

		}

	}

	/**
	 * This method is used to delete all records from the Database ,CAUTION:Highly
	 * sensible code
	 * 
	 * @throws DbException
	 * 
	 */
	public static void deleteAllRecords() throws DbException {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "delete from debtuser_db";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);

		}

	}

	/**
	 * This method returns the parametered book if it has orElse returns null
	 * 
	 * @param bookName
	 * @return
	 * @throws DbException
	 */

	public static List<BookDetail> searchBooks(long userId) throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<BookDetail> searchResults = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from debtuser_db where user_id=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);

			rs = pst.executeQuery();
			while (rs.next()) {
				String bookName = rs.getString(MessageConstants.BOOK);
				int bookQuantity = rs.getInt(MessageConstants.QUANTITY);

				BookDetail books = new BookDetail();
				books.setName(bookName);
				books.setQuantity(bookQuantity);
				searchResults.add(books);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return searchResults;
	}

	/**
	 * This method returns all records in debtuser_db
	 * 
	 * @return
	 * @throws DbException
	 * @throws ParseException
	 */
	public static List<DebtUserDetail> getAllRecords() throws DbException, ParseException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DebtUserDetail> searchResults = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from debtuser_db  order by taken_date desc";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String bookName = rs.getString(MessageConstants.BOOK);
				int bookQuantity = rs.getInt(MessageConstants.QUANTITY);
				Date takenDate = rs.getDate(MessageConstants.DATE);
				int userId = rs.getInt(MessageConstants.USER_ID);

				SimpleDateFormat obj = new SimpleDateFormat("dd-MMM-yyyy");
				String strDate = obj.format(takenDate);

				DebtUserDetail user = new DebtUserDetail();
				user.setTakenBook(bookName);
				user.setTekenBookQuantity(bookQuantity);
				user.setDebtUserId(userId);
				user.setStrDate(strDate);

				searchResults.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return searchResults;

	}

	/**
	 * This method is used to get the taken date of the books
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static Date getDate(long userId, String bookName) throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		java.sql.Date date = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select taken_date from debtuser_db where user_id=? AND taken_book=?";
			pst = con.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setString(2, bookName);

			rs = pst.executeQuery();
			while (rs.next()) {

				date = rs.getDate(MessageConstants.DATE);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return date;

	}

	public static void updateDate(long userId, java.sql.Date date, String bookName) throws DbException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update debtuser_db set taken_date= ? where taken_book = ? AND user_id=?";
			pst = con.prepareStatement(sql);

			pst.setDate(1, date);
			pst.setString(2, bookName);
			pst.setLong(3, userId);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}

	public static List<DebtUserDetail> getDebtUserOfId(long userID) throws DbException {
		List<DebtUserDetail> resultDebtUser = new ArrayList<>();
		Long userid = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from debtuser_db where user_id=?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, userID);

			rs = pst.executeQuery();
			while (rs.next()) {
				DebtUserDetail user = new DebtUserDetail();
				userid = rs.getLong(MessageConstants.USER_ID);
				String bookName = rs.getString(MessageConstants.BOOK);
				int quantity = rs.getInt(MessageConstants.QUANTITY);
				Date date = rs.getDate(MessageConstants.DATE);
				user.setDebtUserId(userid);
				user.setTakenBook(bookName);
				user.setTakenDate(date);
				user.setTekenBookQuantity(quantity);
				resultDebtUser.add(user);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return resultDebtUser;
	}

	public static List<Long> getAllUser() throws DbException {

		List<Long> resultDebtUser = new ArrayList<>();
		Long userid = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select user_id from debtuser_db";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				userid = rs.getLong(MessageConstants.USER_ID);
				resultDebtUser.add(userid);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(MessageConstants.ERROR_MESSAGE);
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}
		return resultDebtUser;
	}

}
